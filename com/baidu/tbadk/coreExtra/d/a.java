package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String fwI;
    private List<String> fwJ;
    private b fwK;
    private boolean fwL;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0570a {
        void bzJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a fwP = new a();
    }

    public static a bzD() {
        return c.fwP;
    }

    private a() {
        this.fwI = null;
        this.fwJ = null;
        this.fwK = null;
        this.fwL = false;
        this.fwL = false;
        this.fwJ = null;
    }

    public int bzE() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bzF() {
        int bzE = bzE();
        if (bzE >= 10) {
            com.baidu.tbadk.core.sharedPref.b.brx().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.brx().putString("KeyOfSharedPrefValidIp", "");
            this.fwI = null;
            return null;
        }
        if (this.fwI == null) {
            this.fwI = com.baidu.tbadk.core.sharedPref.b.brx().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.fwI)) {
            com.baidu.tbadk.core.sharedPref.b.brx().putInt("KeyOfSharedPrefImCount", bzE + 1);
        } else {
            this.fwI = null;
        }
        return this.fwI;
    }

    public void Ce(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.fwI = str;
            com.baidu.tbadk.core.sharedPref.b.brx().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> bzG() {
        if (this.fwJ == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brx().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.brx().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.fwJ = Cf(com.baidu.tbadk.core.sharedPref.b.brx().getString("KeyOfSharedPrefIpList", null));
        }
        return this.fwJ;
    }

    public void bzH() {
        this.fwL = false;
    }

    public boolean bzI() {
        return this.fwL;
    }

    public void a(InterfaceC0570a interfaceC0570a) {
        if (this.fwK == null) {
            this.fwL = true;
            this.fwK = new b(interfaceC0570a);
            this.fwK.setSelfExecute(true);
            this.fwK.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> Cf(String str) {
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
        private InterfaceC0570a fwM;
        private volatile z mNetwork = null;

        public b(InterfaceC0570a interfaceC0570a) {
            this.fwM = null;
            this.fwM = interfaceC0570a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.brX().bsH().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.fwJ = a.this.Cf(optString);
                        if (a.this.fwJ != null && a.this.fwJ.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.fwJ.size(); i++) {
                                String str2 = (String) a.this.fwJ.get(i);
                                f fVar = new f();
                                fVar.Ci(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bzR()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.fwJ = new ArrayList();
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
                                    a.this.fwJ.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.brx().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.brx().putString("KeyOfSharedPrefIpList", str);
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
            a.this.fwK = null;
            if (this.fwM != null) {
                this.fwM.bzJ();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.fwK = null;
            if (this.fwM != null) {
                this.fwM.bzJ();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.fwK = null;
            if (this.fwM != null) {
                this.fwM.bzJ();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.fwK = null;
            super.cancel(true);
        }
    }
}
