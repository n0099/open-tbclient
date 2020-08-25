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
/* loaded from: classes2.dex */
public class a {
    private String eIw;
    private List<String> eIx;
    private b eIy;
    private boolean eIz;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0546a {
        void bqu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private static a eID = new a();
    }

    public static a bqp() {
        return c.eID;
    }

    private a() {
        this.eIw = null;
        this.eIx = null;
        this.eIy = null;
        this.eIz = false;
        this.eIz = false;
        this.eIx = null;
    }

    public int bqq() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bqr() {
        int bqq = bqq();
        if (bqq >= 10) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.bik().putString("KeyOfSharedPrefValidIp", "");
            this.eIw = null;
            return null;
        }
        if (this.eIw == null) {
            this.eIw = com.baidu.tbadk.core.sharedPref.b.bik().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.eIw)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("KeyOfSharedPrefImCount", bqq + 1);
        } else {
            this.eIw = null;
        }
        return this.eIw;
    }

    public void Bv(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.eIw = str;
            com.baidu.tbadk.core.sharedPref.b.bik().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.eIx == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bik().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.bik().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.eIx = Bw(com.baidu.tbadk.core.sharedPref.b.bik().getString("KeyOfSharedPrefIpList", null));
        }
        return this.eIx;
    }

    public void bqs() {
        this.eIz = false;
    }

    public boolean bqt() {
        return this.eIz;
    }

    public void a(InterfaceC0546a interfaceC0546a) {
        if (this.eIy == null) {
            this.eIz = true;
            this.eIy = new b(interfaceC0546a);
            this.eIy.setSelfExecute(true);
            this.eIy.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> Bw(String str) {
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

    /* loaded from: classes2.dex */
    private class b extends BdAsyncTask<Object, Integer, Void> {
        private InterfaceC0546a eIA;
        private volatile aa mNetwork = null;

        public b(InterfaceC0546a interfaceC0546a) {
            this.eIA = null;
            this.eIA = interfaceC0546a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.biQ().bjw().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.eIx = a.this.Bw(optString);
                        if (a.this.eIx != null && a.this.eIx.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.eIx.size(); i++) {
                                String str2 = (String) a.this.eIx.get(i);
                                f fVar = new f();
                                fVar.Bz(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bqC()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.eIx = new ArrayList();
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
                                    a.this.eIx.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.bik().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.bik().putString("KeyOfSharedPrefIpList", str);
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
            a.this.eIy = null;
            if (this.eIA != null) {
                this.eIA.bqu();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.eIy = null;
            if (this.eIA != null) {
                this.eIA.bqu();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.eIy = null;
            if (this.eIA != null) {
                this.eIA.bqu();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.eIy = null;
            super.cancel(true);
        }
    }
}
