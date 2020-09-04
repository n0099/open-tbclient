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
    private String eIA;
    private List<String> eIB;
    private b eIC;
    private boolean eID;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0546a {
        void bqv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a eIH = new a();
    }

    public static a bqq() {
        return c.eIH;
    }

    private a() {
        this.eIA = null;
        this.eIB = null;
        this.eIC = null;
        this.eID = false;
        this.eID = false;
        this.eIB = null;
    }

    public int bqr() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bqs() {
        int bqr = bqr();
        if (bqr >= 10) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.bik().putString("KeyOfSharedPrefValidIp", "");
            this.eIA = null;
            return null;
        }
        if (this.eIA == null) {
            this.eIA = com.baidu.tbadk.core.sharedPref.b.bik().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.eIA)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("KeyOfSharedPrefImCount", bqr + 1);
        } else {
            this.eIA = null;
        }
        return this.eIA;
    }

    public void Bw(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.eIA = str;
            com.baidu.tbadk.core.sharedPref.b.bik().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.eIB == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bik().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.bik().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.eIB = Bx(com.baidu.tbadk.core.sharedPref.b.bik().getString("KeyOfSharedPrefIpList", null));
        }
        return this.eIB;
    }

    public void bqt() {
        this.eID = false;
    }

    public boolean bqu() {
        return this.eID;
    }

    public void a(InterfaceC0546a interfaceC0546a) {
        if (this.eIC == null) {
            this.eID = true;
            this.eIC = new b(interfaceC0546a);
            this.eIC.setSelfExecute(true);
            this.eIC.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> Bx(String str) {
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
        private InterfaceC0546a eIE;
        private volatile aa mNetwork = null;

        public b(InterfaceC0546a interfaceC0546a) {
            this.eIE = null;
            this.eIE = interfaceC0546a;
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
                        a.this.eIB = a.this.Bx(optString);
                        if (a.this.eIB != null && a.this.eIB.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.eIB.size(); i++) {
                                String str2 = (String) a.this.eIB.get(i);
                                f fVar = new f();
                                fVar.BA(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bqD()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.eIB = new ArrayList();
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
                                    a.this.eIB.add(entry.getKey());
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
            a.this.eIC = null;
            if (this.eIE != null) {
                this.eIE.bqv();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.eIC = null;
            if (this.eIE != null) {
                this.eIE.bqv();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.eIC = null;
            if (this.eIE != null) {
                this.eIE.bqv();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.eIC = null;
            super.cancel(true);
        }
    }
}
