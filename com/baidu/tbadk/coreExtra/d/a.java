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
    private b duA;
    private boolean duB;
    private String duy;
    private List<String> duz;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0382a {
        void aNo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a duF = new a();
    }

    public static a aNj() {
        return c.duF;
    }

    private a() {
        this.duy = null;
        this.duz = null;
        this.duA = null;
        this.duB = false;
        this.duB = false;
        this.duz = null;
    }

    public int aNk() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String aNl() {
        int aNk = aNk();
        if (aNk >= 10) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.aFD().putString("KeyOfSharedPrefValidIp", "");
            this.duy = null;
            return null;
        }
        if (this.duy == null) {
            this.duy = com.baidu.tbadk.core.sharedPref.b.aFD().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.duy)) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt("KeyOfSharedPrefImCount", aNk + 1);
        } else {
            this.duy = null;
        }
        return this.duy;
    }

    public void uJ(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.duy = str;
            com.baidu.tbadk.core.sharedPref.b.aFD().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.duz == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aFD().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.duz = uK(com.baidu.tbadk.core.sharedPref.b.aFD().getString("KeyOfSharedPrefIpList", null));
        }
        return this.duz;
    }

    public void aNm() {
        this.duB = false;
    }

    public boolean aNn() {
        return this.duB;
    }

    public void a(InterfaceC0382a interfaceC0382a) {
        if (this.duA == null) {
            this.duB = true;
            this.duA = new b(interfaceC0382a);
            this.duA.setSelfExecute(true);
            this.duA.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> uK(String str) {
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
        private InterfaceC0382a duC;
        private volatile x mNetwork = null;

        public b(InterfaceC0382a interfaceC0382a) {
            this.duC = null;
            this.duC = interfaceC0382a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aGg().aGI().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.duz = a.this.uK(optString);
                        if (a.this.duz != null && a.this.duz.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.duz.size(); i++) {
                                String str2 = (String) a.this.duz.get(i);
                                f fVar = new f();
                                fVar.uN(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.aNw()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.duz = new ArrayList();
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
                                    a.this.duz.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.aFD().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.aFD().putString("KeyOfSharedPrefIpList", str);
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
            a.this.duA = null;
            if (this.duC != null) {
                this.duC.aNo();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.duA = null;
            if (this.duC != null) {
                this.duC.aNo();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.duA = null;
            if (this.duC != null) {
                this.duC.aNo();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.duA = null;
            super.cancel(true);
        }
    }
}
