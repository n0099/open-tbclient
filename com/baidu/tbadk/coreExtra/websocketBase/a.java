package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.w;
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
    private String azl;
    private List<String> azm;
    private b azn;
    private boolean azo;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0051a {
        void BU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a azs = new a();
    }

    public static a BO() {
        return c.azs;
    }

    private a() {
        this.azl = null;
        this.azm = null;
        this.azn = null;
        this.azo = false;
        this.azo = false;
        this.azm = null;
    }

    public int BP() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String BQ() {
        int BP = BP();
        if (BP >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.azl = null;
            return null;
        }
        if (this.azl == null) {
            this.azl = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!j.isEmpty(this.azl)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", BP + 1);
        } else {
            this.azl = null;
        }
        return this.azl;
    }

    public void fr(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.azl = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> BR() {
        if (this.azm == null) {
            this.azm = fs(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.azm;
    }

    public void BS() {
        this.azo = false;
    }

    public boolean BT() {
        return this.azo;
    }

    public void a(InterfaceC0051a interfaceC0051a) {
        if (this.azn == null) {
            this.azo = true;
            this.azn = new b(interfaceC0051a);
            this.azn.setSelfExecute(true);
            this.azn.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> fs(String str) {
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
        private InterfaceC0051a azp;
        private volatile w mNetwork = null;

        public b(InterfaceC0051a interfaceC0051a) {
            this.azp = null;
            this.azp = interfaceC0051a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new w(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String uP = this.mNetwork.uP();
                if (this.mNetwork.vm().wj().isRequestSuccess() && uP != null) {
                    JSONObject jSONObject = new JSONObject(uP);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.azm = a.this.fs(optString);
                        if (a.this.azm != null && a.this.azm.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.azm.size(); i++) {
                                String str2 = (String) a.this.azm.get(i);
                                e eVar = new e();
                                eVar.fv(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.Cg()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.azm = new ArrayList();
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
                                    a.this.azm.add(entry.getKey());
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
            a.this.azn = null;
            if (this.azp != null) {
                this.azp.BU();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onCancelled(Void r3) {
            a.this.azn = null;
            if (this.azp != null) {
                this.azp.BU();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.azn = null;
            if (this.azp != null) {
                this.azp.BU();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
                this.mNetwork = null;
            }
            a.this.azn = null;
            super.cancel(true);
        }
    }
}
