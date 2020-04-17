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
    private String dUF;
    private List<String> dUG;
    private b dUH;
    private boolean dUI;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0413a {
        void aVP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a dUM = new a();
    }

    public static a aVK() {
        return c.dUM;
    }

    private a() {
        this.dUF = null;
        this.dUG = null;
        this.dUH = null;
        this.dUI = false;
        this.dUI = false;
        this.dUG = null;
    }

    public int aVL() {
        return com.baidu.tbadk.core.sharedPref.b.aNV().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String aVM() {
        int aVL = aVL();
        if (aVL >= 10) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.aNV().putString("KeyOfSharedPrefValidIp", "");
            this.dUF = null;
            return null;
        }
        if (this.dUF == null) {
            this.dUF = com.baidu.tbadk.core.sharedPref.b.aNV().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.dUF)) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putInt("KeyOfSharedPrefImCount", aVL + 1);
        } else {
            this.dUF = null;
        }
        return this.dUF;
    }

    public void vX(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.dUF = str;
            com.baidu.tbadk.core.sharedPref.b.aNV().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.dUG == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aNV().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.dUG = vY(com.baidu.tbadk.core.sharedPref.b.aNV().getString("KeyOfSharedPrefIpList", null));
        }
        return this.dUG;
    }

    public void aVN() {
        this.dUI = false;
    }

    public boolean aVO() {
        return this.dUI;
    }

    public void a(InterfaceC0413a interfaceC0413a) {
        if (this.dUH == null) {
            this.dUI = true;
            this.dUH = new b(interfaceC0413a);
            this.dUH.setSelfExecute(true);
            this.dUH.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> vY(String str) {
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
        private InterfaceC0413a dUJ;
        private volatile x mNetwork = null;

        public b(InterfaceC0413a interfaceC0413a) {
            this.dUJ = null;
            this.dUJ = interfaceC0413a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aOy().aPa().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.dUG = a.this.vY(optString);
                        if (a.this.dUG != null && a.this.dUG.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.dUG.size(); i++) {
                                String str2 = (String) a.this.dUG.get(i);
                                f fVar = new f();
                                fVar.wb(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.aVX()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.dUG = new ArrayList();
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
                                    a.this.dUG.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.aNV().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.aNV().putString("KeyOfSharedPrefIpList", str);
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
            a.this.dUH = null;
            if (this.dUJ != null) {
                this.dUJ.aVP();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.dUH = null;
            if (this.dUJ != null) {
                this.dUJ.aVP();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.dUH = null;
            if (this.dUJ != null) {
                this.dUJ.aVP();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.dUH = null;
            super.cancel(true);
        }
    }
}
