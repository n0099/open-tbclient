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
    private String aJD;
    private List<String> aJE;
    private b aJF;
    private boolean aJG;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0108a {
        void Gs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aJK = new a();
    }

    public static a Gm() {
        return c.aJK;
    }

    private a() {
        this.aJD = null;
        this.aJE = null;
        this.aJF = null;
        this.aJG = false;
        this.aJG = false;
        this.aJE = null;
    }

    public int Gn() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Go() {
        int Gn = Gn();
        if (Gn >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.aJD = null;
            return null;
        }
        if (this.aJD == null) {
            this.aJD = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.aJD)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", Gn + 1);
        } else {
            this.aJD = null;
        }
        return this.aJD;
    }

    public void gh(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aJD = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Gp() {
        if (this.aJE == null) {
            this.aJE = gi(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aJE;
    }

    public void Gq() {
        this.aJG = false;
    }

    public boolean Gr() {
        return this.aJG;
    }

    public void a(InterfaceC0108a interfaceC0108a) {
        if (this.aJF == null) {
            this.aJG = true;
            this.aJF = new b(interfaceC0108a);
            this.aJF.setSelfExecute(true);
            this.aJF.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> gi(String str) {
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
        private InterfaceC0108a aJH;
        private volatile y mNetwork = null;

        public b(InterfaceC0108a interfaceC0108a) {
            this.aJH = null;
            this.aJH = interfaceC0108a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String yq = this.mNetwork.yq();
                if (this.mNetwork.yO().zN().isRequestSuccess() && yq != null) {
                    JSONObject jSONObject = new JSONObject(yq);
                    if (jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aJE = a.this.gi(optString);
                        if (a.this.aJE != null && a.this.aJE.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.aJE.size(); i++) {
                                String str2 = (String) a.this.aJE.get(i);
                                e eVar = new e();
                                eVar.gl(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.GE()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aJE = new ArrayList();
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
                                    a.this.aJE.add(entry.getKey());
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
            a.this.aJF = null;
            if (this.aJH != null) {
                this.aJH.Gs();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.aJF = null;
            if (this.aJH != null) {
                this.aJH.Gs();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aJF = null;
            if (this.aJH != null) {
                this.aJH.Gs();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            a.this.aJF = null;
            super.cancel(true);
        }
    }
}
