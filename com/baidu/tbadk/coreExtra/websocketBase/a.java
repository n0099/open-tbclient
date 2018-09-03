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
    private String aJA;
    private List<String> aJB;
    private b aJC;
    private boolean aJD;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0108a {
        void Gs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aJH = new a();
    }

    public static a Gm() {
        return c.aJH;
    }

    private a() {
        this.aJA = null;
        this.aJB = null;
        this.aJC = null;
        this.aJD = false;
        this.aJD = false;
        this.aJB = null;
    }

    public int Gn() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Go() {
        int Gn = Gn();
        if (Gn >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.aJA = null;
            return null;
        }
        if (this.aJA == null) {
            this.aJA = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.aJA)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", Gn + 1);
        } else {
            this.aJA = null;
        }
        return this.aJA;
    }

    public void gh(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aJA = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Gp() {
        if (this.aJB == null) {
            this.aJB = gi(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aJB;
    }

    public void Gq() {
        this.aJD = false;
    }

    public boolean Gr() {
        return this.aJD;
    }

    public void a(InterfaceC0108a interfaceC0108a) {
        if (this.aJC == null) {
            this.aJD = true;
            this.aJC = new b(interfaceC0108a);
            this.aJC.setSelfExecute(true);
            this.aJC.execute(new Object[0]);
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
        private InterfaceC0108a aJE;
        private volatile y mNetwork = null;

        public b(InterfaceC0108a interfaceC0108a) {
            this.aJE = null;
            this.aJE = interfaceC0108a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String yo = this.mNetwork.yo();
                if (this.mNetwork.yM().zL().isRequestSuccess() && yo != null) {
                    JSONObject jSONObject = new JSONObject(yo);
                    if (jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aJB = a.this.gi(optString);
                        if (a.this.aJB != null && a.this.aJB.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.aJB.size(); i++) {
                                String str2 = (String) a.this.aJB.get(i);
                                e eVar = new e();
                                eVar.gl(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.GE()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aJB = new ArrayList();
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
                                    a.this.aJB.add(entry.getKey());
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
            a.this.aJC = null;
            if (this.aJE != null) {
                this.aJE.Gs();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.aJC = null;
            if (this.aJE != null) {
                this.aJE.Gs();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aJC = null;
            if (this.aJE != null) {
                this.aJE.Gs();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            a.this.aJC = null;
            super.cancel(true);
        }
    }
}
