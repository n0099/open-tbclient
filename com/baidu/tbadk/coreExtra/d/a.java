package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
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
    private String dqc;
    private List<String> dqd;
    private b dqe;
    private boolean dqf;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0372a {
        void aKP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a dqj = new a();
    }

    public static a aKK() {
        return c.dqj;
    }

    private a() {
        this.dqc = null;
        this.dqd = null;
        this.dqe = null;
        this.dqf = false;
        this.dqf = false;
        this.dqd = null;
    }

    public int aKL() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String aKM() {
        int aKL = aKL();
        if (aKL >= 10) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.aDr().putString("KeyOfSharedPrefValidIp", "");
            this.dqc = null;
            return null;
        }
        if (this.dqc == null) {
            this.dqc = com.baidu.tbadk.core.sharedPref.b.aDr().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.dqc)) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putInt("KeyOfSharedPrefImCount", aKL + 1);
        } else {
            this.dqc = null;
        }
        return this.dqc;
    }

    public void ur(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.dqc = str;
            com.baidu.tbadk.core.sharedPref.b.aDr().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.dqd == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aDr().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.dqd = us(com.baidu.tbadk.core.sharedPref.b.aDr().getString("KeyOfSharedPrefIpList", null));
        }
        return this.dqd;
    }

    public void aKN() {
        this.dqf = false;
    }

    public boolean aKO() {
        return this.dqf;
    }

    public void a(InterfaceC0372a interfaceC0372a) {
        if (this.dqe == null) {
            this.dqf = true;
            this.dqe = new b(interfaceC0372a);
            this.dqe.setSelfExecute(true);
            this.dqe.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> us(String str) {
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
        private InterfaceC0372a dqg;
        private volatile x mNetwork = null;

        public b(InterfaceC0372a interfaceC0372a) {
            this.dqg = null;
            this.dqg = interfaceC0372a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aDU().aEv().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.dqd = a.this.us(optString);
                        if (a.this.dqd != null && a.this.dqd.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.dqd.size(); i++) {
                                String str2 = (String) a.this.dqd.get(i);
                                f fVar = new f();
                                fVar.uv(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.aKX()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.dqd = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.d.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.f.b.toInt(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.f.b.toInt(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.dqd.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.aDr().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.aDr().putString("KeyOfSharedPrefIpList", str);
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
            a.this.dqe = null;
            if (this.dqg != null) {
                this.dqg.aKP();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.dqe = null;
            if (this.dqg != null) {
                this.dqg.aKP();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.dqe = null;
            if (this.dqg != null) {
                this.dqg.aKP();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.dqe = null;
            super.cancel(true);
        }
    }
}
