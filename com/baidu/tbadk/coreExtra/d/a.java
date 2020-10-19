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
    private String eWO;
    private List<String> eWP;
    private b eWQ;
    private boolean eWR;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0558a {
        void btZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a eWV = new a();
    }

    public static a btU() {
        return c.eWV;
    }

    private a() {
        this.eWO = null;
        this.eWP = null;
        this.eWQ = null;
        this.eWR = false;
        this.eWR = false;
        this.eWP = null;
    }

    public int btV() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String btW() {
        int btV = btV();
        if (btV >= 10) {
            com.baidu.tbadk.core.sharedPref.b.blO().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.blO().putString("KeyOfSharedPrefValidIp", "");
            this.eWO = null;
            return null;
        }
        if (this.eWO == null) {
            this.eWO = com.baidu.tbadk.core.sharedPref.b.blO().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.eWO)) {
            com.baidu.tbadk.core.sharedPref.b.blO().putInt("KeyOfSharedPrefImCount", btV + 1);
        } else {
            this.eWO = null;
        }
        return this.eWO;
    }

    public void CE(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.eWO = str;
            com.baidu.tbadk.core.sharedPref.b.blO().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.eWP == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.blO().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.blO().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.eWP = CF(com.baidu.tbadk.core.sharedPref.b.blO().getString("KeyOfSharedPrefIpList", null));
        }
        return this.eWP;
    }

    public void btX() {
        this.eWR = false;
    }

    public boolean btY() {
        return this.eWR;
    }

    public void a(InterfaceC0558a interfaceC0558a) {
        if (this.eWQ == null) {
            this.eWR = true;
            this.eWQ = new b(interfaceC0558a);
            this.eWQ.setSelfExecute(true);
            this.eWQ.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> CF(String str) {
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
        private InterfaceC0558a eWS;
        private volatile aa mNetwork = null;

        public b(InterfaceC0558a interfaceC0558a) {
            this.eWS = null;
            this.eWS = interfaceC0558a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bmu().bnb().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.eWP = a.this.CF(optString);
                        if (a.this.eWP != null && a.this.eWP.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.eWP.size(); i++) {
                                String str2 = (String) a.this.eWP.get(i);
                                f fVar = new f();
                                fVar.CI(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.buh()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.eWP = new ArrayList();
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
                                    a.this.eWP.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.blO().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.blO().putString("KeyOfSharedPrefIpList", str);
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
            a.this.eWQ = null;
            if (this.eWS != null) {
                this.eWS.btZ();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.eWQ = null;
            if (this.eWS != null) {
                this.eWS.btZ();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.eWQ = null;
            if (this.eWS != null) {
                this.eWS.btZ();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.eWQ = null;
            super.cancel(true);
        }
    }
}
