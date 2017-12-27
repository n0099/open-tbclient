package com.baidu.tbadk.coreExtra.websocketBase;

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
    private String bnj;
    private List<String> bnk;
    private b bnl;
    private boolean bnm;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0080a {
        void Jz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a bnq = new a();
    }

    public static a Jt() {
        return c.bnq;
    }

    private a() {
        this.bnj = null;
        this.bnk = null;
        this.bnl = null;
        this.bnm = false;
        this.bnm = false;
        this.bnk = null;
    }

    public int Ju() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Jv() {
        int Ju = Ju();
        if (Ju >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.bnj = null;
            return null;
        }
        if (this.bnj == null) {
            this.bnj = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.bnj)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", Ju + 1);
        } else {
            this.bnj = null;
        }
        return this.bnj;
    }

    public void fy(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.bnj = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Jw() {
        if (this.bnk == null) {
            this.bnk = fz(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.bnk;
    }

    public void Jx() {
        this.bnm = false;
    }

    public boolean Jy() {
        return this.bnm;
    }

    public void a(InterfaceC0080a interfaceC0080a) {
        if (this.bnl == null) {
            this.bnm = true;
            this.bnl = new b(interfaceC0080a);
            this.bnl.setSelfExecute(true);
            this.bnl.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> fz(String str) {
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
        private InterfaceC0080a bnn;
        private volatile x mNetwork = null;

        public b(InterfaceC0080a interfaceC0080a) {
            this.bnn = null;
            this.bnn = interfaceC0080a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String BP = this.mNetwork.BP();
                if (this.mNetwork.Cn().Dl().isRequestSuccess() && BP != null) {
                    JSONObject jSONObject = new JSONObject(BP);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.bnk = a.this.fz(optString);
                        if (a.this.bnk != null && a.this.bnk.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.bnk.size(); i++) {
                                String str2 = (String) a.this.bnk.get(i);
                                e eVar = new e();
                                eVar.fC(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.JL()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.bnk = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.websocketBase.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.h(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.h(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.bnk.add(entry.getKey());
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
        /* renamed from: a */
        public void onPostExecute(Void r3) {
            a.this.bnl = null;
            if (this.bnn != null) {
                this.bnn.Jz();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onCancelled(Void r3) {
            a.this.bnl = null;
            if (this.bnn != null) {
                this.bnn.Jz();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.bnl = null;
            if (this.bnn != null) {
                this.bnn.Jz();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mR();
                this.mNetwork = null;
            }
            a.this.bnl = null;
            super.cancel(true);
        }
    }
}
