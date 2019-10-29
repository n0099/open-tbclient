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
    private String cCW;
    private List<String> cCX;
    private b cCY;
    private boolean cCZ;

    /* renamed from: com.baidu.tbadk.coreExtra.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0288a {
        void ata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a cDd = new a();
    }

    public static a asU() {
        return c.cDd;
    }

    private a() {
        this.cCW = null;
        this.cCX = null;
        this.cCY = null;
        this.cCZ = false;
        this.cCZ = false;
        this.cCX = null;
    }

    public int asV() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String asW() {
        int asV = asV();
        if (asV >= 10) {
            com.baidu.tbadk.core.sharedPref.b.alR().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.alR().putString("KeyOfSharedPrefValidIp", "");
            this.cCW = null;
            return null;
        }
        if (this.cCW == null) {
            this.cCW = com.baidu.tbadk.core.sharedPref.b.alR().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.cCW)) {
            com.baidu.tbadk.core.sharedPref.b.alR().putInt("KeyOfSharedPrefImCount", asV + 1);
        } else {
            this.cCW = null;
        }
        return this.cCW;
    }

    public void pi(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.cCW = str;
            com.baidu.tbadk.core.sharedPref.b.alR().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> asX() {
        if (this.cCX == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.alR().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.alR().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.cCX = pj(com.baidu.tbadk.core.sharedPref.b.alR().getString("KeyOfSharedPrefIpList", null));
        }
        return this.cCX;
    }

    public void asY() {
        this.cCZ = false;
    }

    public boolean asZ() {
        return this.cCZ;
    }

    public void a(InterfaceC0288a interfaceC0288a) {
        if (this.cCY == null) {
            this.cCZ = true;
            this.cCY = new b(interfaceC0288a);
            this.cCY.setSelfExecute(true);
            this.cCY.execute(new Object[0]);
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
        private InterfaceC0288a cDa;
        private volatile x mNetwork = null;

        public b(InterfaceC0288a interfaceC0288a) {
            this.cDa = null;
            this.cDa = interfaceC0288a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.amr().amS().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.cCX = a.this.pj(optString);
                        if (a.this.cCX != null && a.this.cCX.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.cCX.size(); i++) {
                                String str2 = (String) a.this.cCX.get(i);
                                f fVar = new f();
                                fVar.pm(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.ati()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.cCX = new ArrayList();
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
                                    a.this.cCX.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.alR().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.alR().putString("KeyOfSharedPrefIpList", str);
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
            a.this.cCY = null;
            if (this.cDa != null) {
                this.cDa.ata();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.cCY = null;
            if (this.cDa != null) {
                this.cDa.ata();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.cCY = null;
            if (this.cDa != null) {
                this.cDa.ata();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.cCY = null;
            super.cancel(true);
        }
    }
}
