package com.baidu.tbadk.coreExtra.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String cpi;
    private List<String> cpj;
    private b cpk;
    private boolean cpl;

    /* renamed from: com.baidu.tbadk.coreExtra.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0247a {
        void aqU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a cpp = new a();
    }

    public static a aqO() {
        return c.cpp;
    }

    private a() {
        this.cpi = null;
        this.cpj = null;
        this.cpk = null;
        this.cpl = false;
        this.cpl = false;
        this.cpj = null;
    }

    public int aqP() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String aqQ() {
        int aqP = aqP();
        if (aqP >= 10) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.ahO().putString("KeyOfSharedPrefValidIp", "");
            this.cpi = null;
            return null;
        }
        if (this.cpi == null) {
            this.cpi = com.baidu.tbadk.core.sharedPref.b.ahO().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.cpi)) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("KeyOfSharedPrefImCount", aqP + 1);
        } else {
            this.cpi = null;
        }
        return this.cpi;
    }

    public void pN(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.cpi = str;
            com.baidu.tbadk.core.sharedPref.b.ahO().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> aqR() {
        if (this.cpj == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ahO().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.ahO().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.cpj = pO(com.baidu.tbadk.core.sharedPref.b.ahO().getString("KeyOfSharedPrefIpList", null));
        }
        return this.cpj;
    }

    public void aqS() {
        this.cpl = false;
    }

    public boolean aqT() {
        return this.cpl;
    }

    public void a(InterfaceC0247a interfaceC0247a) {
        if (this.cpk == null) {
            this.cpl = true;
            this.cpk = new b(interfaceC0247a);
            this.cpk.setSelfExecute(true);
            this.cpk.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> pO(String str) {
        String[] split;
        ArrayList arrayList = null;
        if (str != null && str.length() > 0 && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length > 0) {
            arrayList = new ArrayList(3);
            for (String str2 : split) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<Object, Integer, Void> {
        private InterfaceC0247a cpm;
        private volatile x mNetwork = null;

        public b(InterfaceC0247a interfaceC0247a) {
            this.cpm = null;
            this.cpm = interfaceC0247a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String aig = this.mNetwork.aig();
                if (this.mNetwork.aiE().ajF().isRequestSuccess() && aig != null) {
                    JSONObject jSONObject = new JSONObject(aig);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.cpj = a.this.pO(optString);
                        if (a.this.cpj != null && a.this.cpj.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.cpj.size(); i++) {
                                String str2 = (String) a.this.cpj.get(i);
                                f fVar = new f();
                                fVar.pR(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.arf()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.cpj = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.e.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.f(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.f(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.cpj.add(entry.getKey());
                                    if (i2 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    i2++;
                                    sb.append((String) entry.getKey());
                                }
                                str = sb.toString();
                            } else {
                                str = optString;
                            }
                            com.baidu.tbadk.core.sharedPref.b.ahO().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.ahO().putString("KeyOfSharedPrefIpList", str);
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
            a.this.cpk = null;
            if (this.cpm != null) {
                this.cpm.aqU();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.cpk = null;
            if (this.cpm != null) {
                this.cpm.aqU();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.cpk = null;
            if (this.cpm != null) {
                this.cpm.aqU();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
            a.this.cpk = null;
            super.cancel(true);
        }
    }
}
