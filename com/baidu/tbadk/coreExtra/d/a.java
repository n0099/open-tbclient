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
    private String eKH;
    private List<String> eKI;
    private b eKJ;
    private boolean eKK;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0541a {
        void brp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a eKO = new a();
    }

    public static a brk() {
        return c.eKO;
    }

    private a() {
        this.eKH = null;
        this.eKI = null;
        this.eKJ = null;
        this.eKK = false;
        this.eKK = false;
        this.eKI = null;
    }

    public int brl() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String brm() {
        int brl = brl();
        if (brl >= 10) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.bjf().putString("KeyOfSharedPrefValidIp", "");
            this.eKH = null;
            return null;
        }
        if (this.eKH == null) {
            this.eKH = com.baidu.tbadk.core.sharedPref.b.bjf().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.eKH)) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("KeyOfSharedPrefImCount", brl + 1);
        } else {
            this.eKH = null;
        }
        return this.eKH;
    }

    public void BS(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.eKH = str;
            com.baidu.tbadk.core.sharedPref.b.bjf().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.eKI == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bjf().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.eKI = BT(com.baidu.tbadk.core.sharedPref.b.bjf().getString("KeyOfSharedPrefIpList", null));
        }
        return this.eKI;
    }

    public void brn() {
        this.eKK = false;
    }

    public boolean bro() {
        return this.eKK;
    }

    public void a(InterfaceC0541a interfaceC0541a) {
        if (this.eKJ == null) {
            this.eKK = true;
            this.eKJ = new b(interfaceC0541a);
            this.eKJ.setSelfExecute(true);
            this.eKJ.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> BT(String str) {
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
        private InterfaceC0541a eKL;
        private volatile aa mNetwork = null;

        public b(InterfaceC0541a interfaceC0541a) {
            this.eKL = null;
            this.eKL = interfaceC0541a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bjL().bkr().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.eKI = a.this.BT(optString);
                        if (a.this.eKI != null && a.this.eKI.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.eKI.size(); i++) {
                                String str2 = (String) a.this.eKI.get(i);
                                f fVar = new f();
                                fVar.BW(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.brx()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.eKI = new ArrayList();
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
                                    a.this.eKI.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.bjf().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.bjf().putString("KeyOfSharedPrefIpList", str);
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
            a.this.eKJ = null;
            if (this.eKL != null) {
                this.eKL.brp();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.eKJ = null;
            if (this.eKL != null) {
                this.eKL.brp();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.eKJ = null;
            if (this.eKL != null) {
                this.eKL.brp();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.eKJ = null;
            super.cancel(true);
        }
    }
}
