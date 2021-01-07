package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String fBq;
    private List<String> fBr;
    private b fBs;
    private boolean fBt;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0587a {
        void bDD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a fBx = new a();
    }

    public static a bDx() {
        return c.fBx;
    }

    private a() {
        this.fBq = null;
        this.fBr = null;
        this.fBs = null;
        this.fBt = false;
        this.fBt = false;
        this.fBr = null;
    }

    public int bDy() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bDz() {
        int bDy = bDy();
        if (bDy >= 10) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.bvr().putString("KeyOfSharedPrefValidIp", "");
            this.fBq = null;
            return null;
        }
        if (this.fBq == null) {
            this.fBq = com.baidu.tbadk.core.sharedPref.b.bvr().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.fBq)) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt("KeyOfSharedPrefImCount", bDy + 1);
        } else {
            this.fBq = null;
        }
        return this.fBq;
    }

    public void Dp(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.fBq = str;
            com.baidu.tbadk.core.sharedPref.b.bvr().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> bDA() {
        if (this.fBr == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bvr().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.bvr().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.fBr = Dq(com.baidu.tbadk.core.sharedPref.b.bvr().getString("KeyOfSharedPrefIpList", null));
        }
        return this.fBr;
    }

    public void bDB() {
        this.fBt = false;
    }

    public boolean bDC() {
        return this.fBt;
    }

    public void a(InterfaceC0587a interfaceC0587a) {
        if (this.fBs == null) {
            this.fBt = true;
            this.fBs = new b(interfaceC0587a);
            this.fBs.setSelfExecute(true);
            this.fBs.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> Dq(String str) {
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
        private InterfaceC0587a fBu;
        private volatile z mNetwork = null;

        public b(InterfaceC0587a interfaceC0587a) {
            this.fBu = null;
            this.fBu = interfaceC0587a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bvR().bwB().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.fBr = a.this.Dq(optString);
                        if (a.this.fBr != null && a.this.fBr.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.fBr.size(); i++) {
                                String str2 = (String) a.this.fBr.get(i);
                                f fVar = new f();
                                fVar.Dt(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bDL()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.fBr = new ArrayList();
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
                                    a.this.fBr.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.bvr().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.bvr().putString("KeyOfSharedPrefIpList", str);
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
            a.this.fBs = null;
            if (this.fBu != null) {
                this.fBu.bDD();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.fBs = null;
            if (this.fBu != null) {
                this.fBu.bDD();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.fBs = null;
            if (this.fBu != null) {
                this.fBu.bDD();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.fBs = null;
            super.cancel(true);
        }
    }
}
