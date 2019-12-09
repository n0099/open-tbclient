package com.baidu.tbadk.coreExtra.e;

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
    private String cCf;
    private List<String> cCg;
    private b cCh;
    private boolean cCi;

    /* renamed from: com.baidu.tbadk.coreExtra.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0283a {
        void asY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a cCm = new a();
    }

    public static a asS() {
        return c.cCm;
    }

    private a() {
        this.cCf = null;
        this.cCg = null;
        this.cCh = null;
        this.cCi = false;
        this.cCi = false;
        this.cCg = null;
    }

    public int asT() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String asU() {
        int asT = asT();
        if (asT >= 10) {
            com.baidu.tbadk.core.sharedPref.b.alP().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.alP().putString("KeyOfSharedPrefValidIp", "");
            this.cCf = null;
            return null;
        }
        if (this.cCf == null) {
            this.cCf = com.baidu.tbadk.core.sharedPref.b.alP().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.cCf)) {
            com.baidu.tbadk.core.sharedPref.b.alP().putInt("KeyOfSharedPrefImCount", asT + 1);
        } else {
            this.cCf = null;
        }
        return this.cCf;
    }

    public void pi(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.cCf = str;
            com.baidu.tbadk.core.sharedPref.b.alP().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> asV() {
        if (this.cCg == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.alP().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.alP().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.cCg = pj(com.baidu.tbadk.core.sharedPref.b.alP().getString("KeyOfSharedPrefIpList", null));
        }
        return this.cCg;
    }

    public void asW() {
        this.cCi = false;
    }

    public boolean asX() {
        return this.cCi;
    }

    public void a(InterfaceC0283a interfaceC0283a) {
        if (this.cCh == null) {
            this.cCi = true;
            this.cCh = new b(interfaceC0283a);
            this.cCh.setSelfExecute(true);
            this.cCh.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> pj(String str) {
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
        private InterfaceC0283a cCj;
        private volatile x mNetwork = null;

        public b(InterfaceC0283a interfaceC0283a) {
            this.cCj = null;
            this.cCj = interfaceC0283a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.amp().amQ().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.cCg = a.this.pj(optString);
                        if (a.this.cCg != null && a.this.cCg.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.cCg.size(); i++) {
                                String str2 = (String) a.this.cCg.get(i);
                                f fVar = new f();
                                fVar.pm(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.atg()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.cCg = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.e.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.toInt(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.toInt(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.cCg.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.alP().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.alP().putString("KeyOfSharedPrefIpList", str);
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
            a.this.cCh = null;
            if (this.cCj != null) {
                this.cCj.asY();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.cCh = null;
            if (this.cCj != null) {
                this.cCj.asY();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.cCh = null;
            if (this.cCj != null) {
                this.cCj.asY();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.cCh = null;
            super.cancel(true);
        }
    }
}
