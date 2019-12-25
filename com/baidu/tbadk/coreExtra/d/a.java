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
    private String dpR;
    private List<String> dpS;
    private b dpT;
    private boolean dpU;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0370a {
        void aKw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a dpY = new a();
    }

    public static a aKr() {
        return c.dpY;
    }

    private a() {
        this.dpR = null;
        this.dpS = null;
        this.dpT = null;
        this.dpU = false;
        this.dpU = false;
        this.dpS = null;
    }

    public int aKs() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String aKt() {
        int aKs = aKs();
        if (aKs >= 10) {
            com.baidu.tbadk.core.sharedPref.b.aCY().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.aCY().putString("KeyOfSharedPrefValidIp", "");
            this.dpR = null;
            return null;
        }
        if (this.dpR == null) {
            this.dpR = com.baidu.tbadk.core.sharedPref.b.aCY().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.dpR)) {
            com.baidu.tbadk.core.sharedPref.b.aCY().putInt("KeyOfSharedPrefImCount", aKs + 1);
        } else {
            this.dpR = null;
        }
        return this.dpR;
    }

    public void um(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.dpR = str;
            com.baidu.tbadk.core.sharedPref.b.aCY().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.dpS == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aCY().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.dpS = un(com.baidu.tbadk.core.sharedPref.b.aCY().getString("KeyOfSharedPrefIpList", null));
        }
        return this.dpS;
    }

    public void aKu() {
        this.dpU = false;
    }

    public boolean aKv() {
        return this.dpU;
    }

    public void a(InterfaceC0370a interfaceC0370a) {
        if (this.dpT == null) {
            this.dpU = true;
            this.dpT = new b(interfaceC0370a);
            this.dpT.setSelfExecute(true);
            this.dpT.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> un(String str) {
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
        private InterfaceC0370a dpV;
        private volatile x mNetwork = null;

        public b(InterfaceC0370a interfaceC0370a) {
            this.dpV = null;
            this.dpV = interfaceC0370a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aDB().aEc().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.dpS = a.this.un(optString);
                        if (a.this.dpS != null && a.this.dpS.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.dpS.size(); i++) {
                                String str2 = (String) a.this.dpS.get(i);
                                f fVar = new f();
                                fVar.uq(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.aKE()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.dpS = new ArrayList();
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
                                    a.this.dpS.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.aCY().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.aCY().putString("KeyOfSharedPrefIpList", str);
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
            a.this.dpT = null;
            if (this.dpV != null) {
                this.dpV.aKw();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.dpT = null;
            if (this.dpV != null) {
                this.dpV.aKw();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.dpT = null;
            if (this.dpV != null) {
                this.dpV.aKw();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.dpT = null;
            super.cancel(true);
        }
    }
}
