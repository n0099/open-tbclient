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
    private String eiT;
    private List<String> eiU;
    private b eiV;
    private boolean eiW;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0481a {
        void bbX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a eja = new a();
    }

    public static a bbS() {
        return c.eja;
    }

    private a() {
        this.eiT = null;
        this.eiU = null;
        this.eiV = null;
        this.eiW = false;
        this.eiW = false;
        this.eiU = null;
    }

    public int bbT() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bbU() {
        int bbT = bbT();
        if (bbT >= 10) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("KeyOfSharedPrefValidIp", "");
            this.eiT = null;
            return null;
        }
        if (this.eiT == null) {
            this.eiT = com.baidu.tbadk.core.sharedPref.b.aTX().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.eiT)) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt("KeyOfSharedPrefImCount", bbT + 1);
        } else {
            this.eiT = null;
        }
        return this.eiT;
    }

    public void xG(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.eiT = str;
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.eiU == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aTX().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.eiU = xH(com.baidu.tbadk.core.sharedPref.b.aTX().getString("KeyOfSharedPrefIpList", null));
        }
        return this.eiU;
    }

    public void bbV() {
        this.eiW = false;
    }

    public boolean bbW() {
        return this.eiW;
    }

    public void a(InterfaceC0481a interfaceC0481a) {
        if (this.eiV == null) {
            this.eiW = true;
            this.eiV = new b(interfaceC0481a);
            this.eiV.setSelfExecute(true);
            this.eiV.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> xH(String str) {
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
        private InterfaceC0481a eiX;
        private volatile x mNetwork = null;

        public b(InterfaceC0481a interfaceC0481a) {
            this.eiX = null;
            this.eiX = interfaceC0481a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aUA().aVc().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.eiU = a.this.xH(optString);
                        if (a.this.eiU != null && a.this.eiU.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.eiU.size(); i++) {
                                String str2 = (String) a.this.eiU.get(i);
                                f fVar = new f();
                                fVar.xK(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bcf()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.eiU = new ArrayList();
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
                                    a.this.eiU.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.aTX().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.aTX().putString("KeyOfSharedPrefIpList", str);
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
            a.this.eiV = null;
            if (this.eiX != null) {
                this.eiX.bbX();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.eiV = null;
            if (this.eiX != null) {
                this.eiX.bbX();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.eiV = null;
            if (this.eiX != null) {
                this.eiX.bbX();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.eiV = null;
            super.cancel(true);
        }
    }
}
