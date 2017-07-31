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
    private String azj;
    private List<String> azk;
    private b azl;
    private boolean azm;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0051a {
        void BU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a azq = new a();
    }

    public static a BO() {
        return c.azq;
    }

    private a() {
        this.azj = null;
        this.azk = null;
        this.azl = null;
        this.azm = false;
        this.azm = false;
        this.azk = null;
    }

    public int BP() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String BQ() {
        int BP = BP();
        if (BP >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.azj = null;
            return null;
        }
        if (this.azj == null) {
            this.azj = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!j.isEmpty(this.azj)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", BP + 1);
        } else {
            this.azj = null;
        }
        return this.azj;
    }

    public void fn(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.azj = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> BR() {
        if (this.azk == null) {
            this.azk = fo(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.azk;
    }

    public void BS() {
        this.azm = false;
    }

    public boolean BT() {
        return this.azm;
    }

    public void a(InterfaceC0051a interfaceC0051a) {
        if (this.azl == null) {
            this.azm = true;
            this.azl = new b(interfaceC0051a);
            this.azl.setSelfExecute(true);
            this.azl.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> fo(String str) {
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
        private InterfaceC0051a azn;
        private volatile w mNetwork = null;

        public b(InterfaceC0051a interfaceC0051a) {
            this.azn = null;
            this.azn = interfaceC0051a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new w(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String uO = this.mNetwork.uO();
                if (this.mNetwork.vl().wi().isRequestSuccess() && uO != null) {
                    JSONObject jSONObject = new JSONObject(uO);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.azk = a.this.fo(optString);
                        if (a.this.azk != null && a.this.azk.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.azk.size(); i++) {
                                String str2 = (String) a.this.azk.get(i);
                                e eVar = new e();
                                eVar.fr(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.Cg()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.azk = new ArrayList();
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
                                    a.this.azk.add(entry.getKey());
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
            a.this.azl = null;
            if (this.azn != null) {
                this.azn.BU();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onCancelled(Void r3) {
            a.this.azl = null;
            if (this.azn != null) {
                this.azn.BU();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.azl = null;
            if (this.azn != null) {
                this.azn.BU();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
                this.mNetwork = null;
            }
            a.this.azl = null;
            super.cancel(true);
        }
    }
}
