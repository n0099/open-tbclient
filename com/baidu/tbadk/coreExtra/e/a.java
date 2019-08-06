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
    private String cpp;
    private List<String> cpq;
    private b cpr;
    private boolean cps;

    /* renamed from: com.baidu.tbadk.coreExtra.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0247a {
        void aqW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a cpx = new a();
    }

    public static a aqQ() {
        return c.cpx;
    }

    private a() {
        this.cpp = null;
        this.cpq = null;
        this.cpr = null;
        this.cps = false;
        this.cps = false;
        this.cpq = null;
    }

    public int aqR() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String aqS() {
        int aqR = aqR();
        if (aqR >= 10) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putString("KeyOfSharedPrefValidIp", "");
            this.cpp = null;
            return null;
        }
        if (this.cpp == null) {
            this.cpp = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.cpp)) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("KeyOfSharedPrefImCount", aqR + 1);
        } else {
            this.cpp = null;
        }
        return this.cpp;
    }

    public void pN(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.cpp = str;
            com.baidu.tbadk.core.sharedPref.b.ahQ().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> aqT() {
        if (this.cpq == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.cpq = pO(com.baidu.tbadk.core.sharedPref.b.ahQ().getString("KeyOfSharedPrefIpList", null));
        }
        return this.cpq;
    }

    public void aqU() {
        this.cps = false;
    }

    public boolean aqV() {
        return this.cps;
    }

    public void a(InterfaceC0247a interfaceC0247a) {
        if (this.cpr == null) {
            this.cps = true;
            this.cpr = new b(interfaceC0247a);
            this.cpr.setSelfExecute(true);
            this.cpr.execute(new Object[0]);
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
        private InterfaceC0247a cpt;
        private volatile x mNetwork = null;

        public b(InterfaceC0247a interfaceC0247a) {
            this.cpt = null;
            this.cpt = interfaceC0247a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String aii = this.mNetwork.aii();
                if (this.mNetwork.aiG().ajH().isRequestSuccess() && aii != null) {
                    JSONObject jSONObject = new JSONObject(aii);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.cpq = a.this.pO(optString);
                        if (a.this.cpq != null && a.this.cpq.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.cpq.size(); i++) {
                                String str2 = (String) a.this.cpq.get(i);
                                f fVar = new f();
                                fVar.pR(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.arh()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.cpq = new ArrayList();
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
                                    a.this.cpq.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.ahQ().putString("KeyOfSharedPrefIpList", str);
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
            a.this.cpr = null;
            if (this.cpt != null) {
                this.cpt.aqW();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.cpr = null;
            if (this.cpt != null) {
                this.cpt.aqW();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.cpr = null;
            if (this.cpt != null) {
                this.cpt.aqW();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
            a.this.cpr = null;
            super.cancel(true);
        }
    }
}
