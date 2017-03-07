package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String avR;
    private List<String> avS;
    private b avT;
    private boolean avU;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0038a {
        void BE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a avY = new a(null);
    }

    public static a By() {
        return c.avY;
    }

    private a() {
        this.avR = null;
        this.avS = null;
        this.avT = null;
        this.avU = false;
        this.avU = false;
        this.avS = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Bz() {
        return com.baidu.tbadk.core.sharedPref.b.uo().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String BA() {
        int Bz = Bz();
        if (Bz >= 10) {
            com.baidu.tbadk.core.sharedPref.b.uo().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.uo().putString("KeyOfSharedPrefValidIp", "");
            this.avR = null;
            return null;
        }
        if (this.avR == null) {
            this.avR = com.baidu.tbadk.core.sharedPref.b.uo().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.avR)) {
            com.baidu.tbadk.core.sharedPref.b.uo().putInt("KeyOfSharedPrefImCount", Bz + 1);
        } else {
            this.avR = null;
        }
        return this.avR;
    }

    public void eG(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.avR = str;
            com.baidu.tbadk.core.sharedPref.b.uo().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> BB() {
        if (this.avS == null) {
            this.avS = eH(com.baidu.tbadk.core.sharedPref.b.uo().getString("KeyOfSharedPrefIpList", null));
        }
        return this.avS;
    }

    public void BC() {
        this.avU = false;
    }

    public boolean BD() {
        return this.avU;
    }

    public void a(InterfaceC0038a interfaceC0038a) {
        if (this.avT == null) {
            this.avU = true;
            this.avT = new b(interfaceC0038a);
            this.avT.setSelfExecute(true);
            this.avT.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eH(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, Void> {
        private InterfaceC0038a avV;
        private volatile z mNetwork = null;

        public b(InterfaceC0038a interfaceC0038a) {
            this.avV = null;
            this.avV = interfaceC0038a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String uB = this.mNetwork.uB();
                if (this.mNetwork.uZ().vT().isRequestSuccess() && uB != null) {
                    JSONObject jSONObject = new JSONObject(uB);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.avS = a.this.eH(optString);
                        if (a.this.avS != null && a.this.avS.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.avS.size(); i2++) {
                                String str2 = (String) a.this.avS.get(i2);
                                h hVar = new h();
                                hVar.eK(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.BQ()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.avS = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.avS.add((String) entry.getKey());
                                    if (i != 0) {
                                        sb.append(",");
                                    }
                                    int i3 = i + 1;
                                    sb.append((String) entry.getKey());
                                    i = i3;
                                }
                                str = sb.toString();
                            } else {
                                str = optString;
                            }
                            com.baidu.tbadk.core.sharedPref.b.uo().putString("KeyOfSharedPrefIpList", str);
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
        /* renamed from: b */
        public void onPostExecute(Void r3) {
            a.this.avT = null;
            if (this.avV != null) {
                this.avV.BE();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.avT = null;
            if (this.avV != null) {
                this.avV.BE();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.avT = null;
            if (this.avV != null) {
                this.avV.BE();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fm();
                this.mNetwork = null;
            }
            a.this.avT = null;
            super.cancel(true);
        }
    }
}
