package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aSi;
    private List<String> aSj;
    private b aSk;
    private boolean aSl;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0156a {
        void JU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aSp = new a();
    }

    public static a JP() {
        return c.aSp;
    }

    private a() {
        this.aSi = null;
        this.aSj = null;
        this.aSk = null;
        this.aSl = false;
        this.aSl = false;
        this.aSj = null;
    }

    public int JQ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String JR() {
        int JQ = JQ();
        if (JQ >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.aSi = null;
            return null;
        }
        if (this.aSi == null) {
            this.aSi = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.aSi)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", JQ + 1);
        } else {
            this.aSi = null;
        }
        return this.aSi;
    }

    public void gT(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aSi = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.aSj == null) {
            this.aSj = gU(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aSj;
    }

    public void JS() {
        this.aSl = false;
    }

    public boolean JT() {
        return this.aSl;
    }

    public void a(InterfaceC0156a interfaceC0156a) {
        if (this.aSk == null) {
            this.aSl = true;
            this.aSk = new b(interfaceC0156a);
            this.aSk.setSelfExecute(true);
            this.aSk.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> gU(String str) {
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
        private InterfaceC0156a aSm;
        private volatile x mNetwork = null;

        public b(InterfaceC0156a interfaceC0156a) {
            this.aSm = null;
            this.aSm = interfaceC0156a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String BH = this.mNetwork.BH();
                if (this.mNetwork.Cf().De().isRequestSuccess() && BH != null) {
                    JSONObject jSONObject = new JSONObject(BH);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aSj = a.this.gU(optString);
                        if (a.this.aSj != null && a.this.aSj.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.aSj.size(); i++) {
                                String str2 = (String) a.this.aSj.get(i);
                                e eVar = new e();
                                eVar.gX(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.Kf()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aSj = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.websocketBase.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.l(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.l(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.aSj.add(entry.getKey());
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
            a.this.aSk = null;
            if (this.aSm != null) {
                this.aSm.JU();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.aSk = null;
            if (this.aSm != null) {
                this.aSm.JU();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aSk = null;
            if (this.aSm != null) {
                this.aSm.JU();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
                this.mNetwork = null;
            }
            a.this.aSk = null;
            super.cancel(true);
        }
    }
}
