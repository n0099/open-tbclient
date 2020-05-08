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
    private String dUK;
    private List<String> dUL;
    private b dUM;
    private boolean dUN;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0434a {
        void aVN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a dUR = new a();
    }

    public static a aVI() {
        return c.dUR;
    }

    private a() {
        this.dUK = null;
        this.dUL = null;
        this.dUM = null;
        this.dUN = false;
        this.dUN = false;
        this.dUL = null;
    }

    public int aVJ() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String aVK() {
        int aVJ = aVJ();
        if (aVJ >= 10) {
            com.baidu.tbadk.core.sharedPref.b.aNT().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.aNT().putString("KeyOfSharedPrefValidIp", "");
            this.dUK = null;
            return null;
        }
        if (this.dUK == null) {
            this.dUK = com.baidu.tbadk.core.sharedPref.b.aNT().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.dUK)) {
            com.baidu.tbadk.core.sharedPref.b.aNT().putInt("KeyOfSharedPrefImCount", aVJ + 1);
        } else {
            this.dUK = null;
        }
        return this.dUK;
    }

    public void wa(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.dUK = str;
            com.baidu.tbadk.core.sharedPref.b.aNT().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.dUL == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aNT().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.dUL = wb(com.baidu.tbadk.core.sharedPref.b.aNT().getString("KeyOfSharedPrefIpList", null));
        }
        return this.dUL;
    }

    public void aVL() {
        this.dUN = false;
    }

    public boolean aVM() {
        return this.dUN;
    }

    public void a(InterfaceC0434a interfaceC0434a) {
        if (this.dUM == null) {
            this.dUN = true;
            this.dUM = new b(interfaceC0434a);
            this.dUM.setSelfExecute(true);
            this.dUM.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> wb(String str) {
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
        private InterfaceC0434a dUO;
        private volatile x mNetwork = null;

        public b(InterfaceC0434a interfaceC0434a) {
            this.dUO = null;
            this.dUO = interfaceC0434a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aOw().aOX().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.dUL = a.this.wb(optString);
                        if (a.this.dUL != null && a.this.dUL.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.dUL.size(); i++) {
                                String str2 = (String) a.this.dUL.get(i);
                                f fVar = new f();
                                fVar.we(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.aVV()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.dUL = new ArrayList();
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
                                    a.this.dUL.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.aNT().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.aNT().putString("KeyOfSharedPrefIpList", str);
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
            a.this.dUM = null;
            if (this.dUO != null) {
                this.dUO.aVN();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.dUM = null;
            if (this.dUO != null) {
                this.dUO.aVN();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.dUM = null;
            if (this.dUO != null) {
                this.dUO.aVN();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.dUM = null;
            super.cancel(true);
        }
    }
}
