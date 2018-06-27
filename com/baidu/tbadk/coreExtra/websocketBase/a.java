package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aJA;
    private String aJx;
    private List<String> aJy;
    private b aJz;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0111a {
        void Gw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aJE = new a();
    }

    public static a Gq() {
        return c.aJE;
    }

    private a() {
        this.aJx = null;
        this.aJy = null;
        this.aJz = null;
        this.aJA = false;
        this.aJA = false;
        this.aJy = null;
    }

    public int Gr() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Gs() {
        int Gr = Gr();
        if (Gr >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.aJx = null;
            return null;
        }
        if (this.aJx == null) {
            this.aJx = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.aJx)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", Gr + 1);
        } else {
            this.aJx = null;
        }
        return this.aJx;
    }

    public void gj(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aJx = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Gt() {
        if (this.aJy == null) {
            this.aJy = gk(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aJy;
    }

    public void Gu() {
        this.aJA = false;
    }

    public boolean Gv() {
        return this.aJA;
    }

    public void a(InterfaceC0111a interfaceC0111a) {
        if (this.aJz == null) {
            this.aJA = true;
            this.aJz = new b(interfaceC0111a);
            this.aJz.setSelfExecute(true);
            this.aJz.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> gk(String str) {
        String[] split;
        ArrayList arrayList = null;
        if (str != null && str.length() > 0 && (split = str.split(",")) != null && split.length > 0) {
            arrayList = new ArrayList(3);
            for (String str2 : split) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<Object, Integer, Void> {
        private InterfaceC0111a aJB;
        private volatile y mNetwork = null;

        public b(InterfaceC0111a interfaceC0111a) {
            this.aJB = null;
            this.aJB = interfaceC0111a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String yz = this.mNetwork.yz();
                if (this.mNetwork.yX().zY().isRequestSuccess() && yz != null) {
                    JSONObject jSONObject = new JSONObject(yz);
                    if (jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aJy = a.this.gk(optString);
                        if (a.this.aJy != null && a.this.aJy.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.aJy.size(); i++) {
                                String str2 = (String) a.this.aJy.get(i);
                                e eVar = new e();
                                eVar.gn(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.GI()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aJy = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.websocketBase.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.g(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.g(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.aJy.add(entry.getKey());
                                    if (i2 != 0) {
                                        sb.append(",");
                                    }
                                    i2++;
                                    sb.append((String) entry.getKey());
                                }
                                str = sb.toString();
                            } else {
                                str = optString;
                            }
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefIpList", str);
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            a.this.aJz = null;
            if (this.aJB != null) {
                this.aJB.Gw();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.aJz = null;
            if (this.aJB != null) {
                this.aJB.Gw();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aJz = null;
            if (this.aJB != null) {
                this.aJB.Gw();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            a.this.aJz = null;
            super.cancel(true);
        }
    }
}
