package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.z;
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
    private String exW;
    private List<String> exX;
    private b exY;
    private boolean exZ;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0500a {
        void bhI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a eyd = new a();
    }

    public static a bhD() {
        return c.eyd;
    }

    private a() {
        this.exW = null;
        this.exX = null;
        this.exY = null;
        this.exZ = false;
        this.exZ = false;
        this.exX = null;
    }

    public int bhE() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bhF() {
        int bhE = bhE();
        if (bhE >= 10) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.aZP().putString("KeyOfSharedPrefValidIp", "");
            this.exW = null;
            return null;
        }
        if (this.exW == null) {
            this.exW = com.baidu.tbadk.core.sharedPref.b.aZP().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.exW)) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt("KeyOfSharedPrefImCount", bhE + 1);
        } else {
            this.exW = null;
        }
        return this.exW;
    }

    public void zf(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.exW = str;
            com.baidu.tbadk.core.sharedPref.b.aZP().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.exX == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aZP().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.exX = zg(com.baidu.tbadk.core.sharedPref.b.aZP().getString("KeyOfSharedPrefIpList", null));
        }
        return this.exX;
    }

    public void bhG() {
        this.exZ = false;
    }

    public boolean bhH() {
        return this.exZ;
    }

    public void a(InterfaceC0500a interfaceC0500a) {
        if (this.exY == null) {
            this.exZ = true;
            this.exY = new b(interfaceC0500a);
            this.exY.setSelfExecute(true);
            this.exY.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> zg(String str) {
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
        private InterfaceC0500a eya;
        private volatile z mNetwork = null;

        public b(InterfaceC0500a interfaceC0500a) {
            this.eya = null;
            this.eya = interfaceC0500a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bav().baX().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.exX = a.this.zg(optString);
                        if (a.this.exX != null && a.this.exX.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.exX.size(); i++) {
                                String str2 = (String) a.this.exX.get(i);
                                f fVar = new f();
                                fVar.zj(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bhQ()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.exX = new ArrayList();
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
                                    a.this.exX.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.aZP().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.aZP().putString("KeyOfSharedPrefIpList", str);
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
            a.this.exY = null;
            if (this.eya != null) {
                this.eya.bhI();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.exY = null;
            if (this.eya != null) {
                this.eya.bhI();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.exY = null;
            if (this.eya != null) {
                this.eya.bhI();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.exY = null;
            super.cancel(true);
        }
    }
}
