package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
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
    private String fkl;
    private List<String> fkm;
    private b fkn;
    private boolean fko;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0583a {
        void bxH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a fks = new a();
    }

    public static a bxC() {
        return c.fks;
    }

    private a() {
        this.fkl = null;
        this.fkm = null;
        this.fkn = null;
        this.fko = false;
        this.fko = false;
        this.fkm = null;
    }

    public int bxD() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bxE() {
        int bxD = bxD();
        if (bxD >= 10) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.bpu().putString("KeyOfSharedPrefValidIp", "");
            this.fkl = null;
            return null;
        }
        if (this.fkl == null) {
            this.fkl = com.baidu.tbadk.core.sharedPref.b.bpu().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.fkl)) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("KeyOfSharedPrefImCount", bxD + 1);
        } else {
            this.fkl = null;
        }
        return this.fkl;
    }

    public void CK(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.fkl = str;
            com.baidu.tbadk.core.sharedPref.b.bpu().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.fkm == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bpu().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.fkm = CL(com.baidu.tbadk.core.sharedPref.b.bpu().getString("KeyOfSharedPrefIpList", null));
        }
        return this.fkm;
    }

    public void bxF() {
        this.fko = false;
    }

    public boolean bxG() {
        return this.fko;
    }

    public void a(InterfaceC0583a interfaceC0583a) {
        if (this.fkn == null) {
            this.fko = true;
            this.fkn = new b(interfaceC0583a);
            this.fkn.setSelfExecute(true);
            this.fkn.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> CL(String str) {
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
        private InterfaceC0583a fkp;
        private volatile aa mNetwork = null;

        public b(InterfaceC0583a interfaceC0583a) {
            this.fkp = null;
            this.fkp = interfaceC0583a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bqa().bqI().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.fkm = a.this.CL(optString);
                        if (a.this.fkm != null && a.this.fkm.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.fkm.size(); i++) {
                                String str2 = (String) a.this.fkm.get(i);
                                f fVar = new f();
                                fVar.CO(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bxP()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.fkm = new ArrayList();
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
                                    a.this.fkm.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.bpu().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.bpu().putString("KeyOfSharedPrefIpList", str);
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
            a.this.fkn = null;
            if (this.fkp != null) {
                this.fkp.bxH();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.fkn = null;
            if (this.fkp != null) {
                this.fkp.bxH();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.fkn = null;
            if (this.fkp != null) {
                this.fkp.bxH();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.fkn = null;
            super.cancel(true);
        }
    }
}
