package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean fAA;
    private String fAx;
    private List<String> fAy;
    private b fAz;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0573a {
        void bAe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a fAE = new a();
    }

    public static a bzY() {
        return c.fAE;
    }

    private a() {
        this.fAx = null;
        this.fAy = null;
        this.fAz = null;
        this.fAA = false;
        this.fAA = false;
        this.fAy = null;
    }

    public int bzZ() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bAa() {
        int bzZ = bzZ();
        if (bzZ >= 10) {
            com.baidu.tbadk.core.sharedPref.b.brR().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.brR().putString("KeyOfSharedPrefValidIp", "");
            this.fAx = null;
            return null;
        }
        if (this.fAx == null) {
            this.fAx = com.baidu.tbadk.core.sharedPref.b.brR().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.fAx)) {
            com.baidu.tbadk.core.sharedPref.b.brR().putInt("KeyOfSharedPrefImCount", bzZ + 1);
        } else {
            this.fAx = null;
        }
        return this.fAx;
    }

    public void CC(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.fAx = str;
            com.baidu.tbadk.core.sharedPref.b.brR().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> bAb() {
        if (this.fAy == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brR().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.brR().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.fAy = CD(com.baidu.tbadk.core.sharedPref.b.brR().getString("KeyOfSharedPrefIpList", null));
        }
        return this.fAy;
    }

    public void bAc() {
        this.fAA = false;
    }

    public boolean bAd() {
        return this.fAA;
    }

    public void a(InterfaceC0573a interfaceC0573a) {
        if (this.fAz == null) {
            this.fAA = true;
            this.fAz = new b(interfaceC0573a);
            this.fAz.setSelfExecute(true);
            this.fAz.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> CD(String str) {
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
        private InterfaceC0573a fAB;
        private volatile aa mNetwork = null;

        public b(InterfaceC0573a interfaceC0573a) {
            this.fAB = null;
            this.fAB = interfaceC0573a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bsu().bte().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.fAy = a.this.CD(optString);
                        if (a.this.fAy != null && a.this.fAy.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.fAy.size(); i++) {
                                String str2 = (String) a.this.fAy.get(i);
                                f fVar = new f();
                                fVar.CG(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bAm()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.fAy = new ArrayList();
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
                                    a.this.fAy.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.brR().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.brR().putString("KeyOfSharedPrefIpList", str);
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
            a.this.fAz = null;
            if (this.fAB != null) {
                this.fAB.bAe();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.fAz = null;
            if (this.fAB != null) {
                this.fAB.bAe();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.fAz = null;
            if (this.fAB != null) {
                this.fAB.bAe();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.fAz = null;
            super.cancel(true);
        }
    }
}
