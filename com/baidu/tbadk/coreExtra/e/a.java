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
    private String cqk;
    private List<String> cql;
    private b cqm;
    private boolean cqn;

    /* renamed from: com.baidu.tbadk.coreExtra.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0256a {
        void ari();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a cqr = new a();
    }

    public static a arc() {
        return c.cqr;
    }

    private a() {
        this.cqk = null;
        this.cql = null;
        this.cqm = null;
        this.cqn = false;
        this.cqn = false;
        this.cql = null;
    }

    public int ard() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String are() {
        int ard = ard();
        if (ard >= 10) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("KeyOfSharedPrefValidIp", "");
            this.cqk = null;
            return null;
        }
        if (this.cqk == null) {
            this.cqk = com.baidu.tbadk.core.sharedPref.b.ahU().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.cqk)) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("KeyOfSharedPrefImCount", ard + 1);
        } else {
            this.cqk = null;
        }
        return this.cqk;
    }

    public void pY(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.cqk = str;
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> arf() {
        if (this.cql == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ahU().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.cql = pZ(com.baidu.tbadk.core.sharedPref.b.ahU().getString("KeyOfSharedPrefIpList", null));
        }
        return this.cql;
    }

    public void arg() {
        this.cqn = false;
    }

    public boolean arh() {
        return this.cqn;
    }

    public void a(InterfaceC0256a interfaceC0256a) {
        if (this.cqm == null) {
            this.cqn = true;
            this.cqm = new b(interfaceC0256a);
            this.cqm.setSelfExecute(true);
            this.cqm.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> pZ(String str) {
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
        private InterfaceC0256a cqo;
        private volatile x mNetwork = null;

        public b(InterfaceC0256a interfaceC0256a) {
            this.cqo = null;
            this.cqo = interfaceC0256a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String aim = this.mNetwork.aim();
                if (this.mNetwork.aiK().ajN().isRequestSuccess() && aim != null) {
                    JSONObject jSONObject = new JSONObject(aim);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.cql = a.this.pZ(optString);
                        if (a.this.cql != null && a.this.cql.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.cql.size(); i++) {
                                String str2 = (String) a.this.cql.get(i);
                                f fVar = new f();
                                fVar.qc(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.art()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.cql = new ArrayList();
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
                                    a.this.cql.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.ahU().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.ahU().putString("KeyOfSharedPrefIpList", str);
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
            a.this.cqm = null;
            if (this.cqo != null) {
                this.cqo.ari();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.cqm = null;
            if (this.cqo != null) {
                this.cqo.ari();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.cqm = null;
            if (this.cqo != null) {
                this.cqo.ari();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
            a.this.cqm = null;
            super.cancel(true);
        }
    }
}
