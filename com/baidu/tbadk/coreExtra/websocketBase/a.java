package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aMQ;
    private List<String> aMR;
    private b aMS;
    private boolean aMT;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0108a {
        void HI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aMX = new a();
    }

    public static a HC() {
        return c.aMX;
    }

    private a() {
        this.aMQ = null;
        this.aMR = null;
        this.aMS = null;
        this.aMT = false;
        this.aMT = false;
        this.aMR = null;
    }

    public int HD() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String HE() {
        int HD = HD();
        if (HD >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.aMQ = null;
            return null;
        }
        if (this.aMQ == null) {
            this.aMQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.aMQ)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", HD + 1);
        } else {
            this.aMQ = null;
        }
        return this.aMQ;
    }

    public void gE(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aMQ = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> HF() {
        if (this.aMR == null) {
            this.aMR = gF(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aMR;
    }

    public void HG() {
        this.aMT = false;
    }

    public boolean HH() {
        return this.aMT;
    }

    public void a(InterfaceC0108a interfaceC0108a) {
        if (this.aMS == null) {
            this.aMT = true;
            this.aMS = new b(interfaceC0108a);
            this.aMS.setSelfExecute(true);
            this.aMS.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> gF(String str) {
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
        private InterfaceC0108a aMU;
        private volatile x mNetwork = null;

        public b(InterfaceC0108a interfaceC0108a) {
            this.aMU = null;
            this.aMU = interfaceC0108a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String zt = this.mNetwork.zt();
                if (this.mNetwork.zR().AQ().isRequestSuccess() && zt != null) {
                    JSONObject jSONObject = new JSONObject(zt);
                    if (jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aMR = a.this.gF(optString);
                        if (a.this.aMR != null && a.this.aMR.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.aMR.size(); i++) {
                                String str2 = (String) a.this.aMR.get(i);
                                e eVar = new e();
                                eVar.gI(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.HU()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aMR = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.websocketBase.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.l(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.l(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.aMR.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefIpList", str);
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
            a.this.aMS = null;
            if (this.aMU != null) {
                this.aMU.HI();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.aMS = null;
            if (this.aMU != null) {
                this.aMU.HI();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aMS = null;
            if (this.aMU != null) {
                this.aMU.HI();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.iT();
                this.mNetwork = null;
            }
            a.this.aMS = null;
            super.cancel(true);
        }
    }
}
