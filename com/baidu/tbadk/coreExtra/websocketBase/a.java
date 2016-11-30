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
    private String arN;
    private List<String> arO;
    private b arP;
    private boolean arQ;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039a {
        void BD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a arU = new a(null);
    }

    public static a Bx() {
        return c.arU;
    }

    private a() {
        this.arN = null;
        this.arO = null;
        this.arP = null;
        this.arQ = false;
        this.arQ = false;
        this.arO = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int By() {
        return com.baidu.tbadk.core.sharedPref.b.um().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Bz() {
        int By = By();
        if (By >= 10) {
            com.baidu.tbadk.core.sharedPref.b.um().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.um().putString("KeyOfSharedPrefValidIp", "");
            this.arN = null;
            return null;
        }
        if (this.arN == null) {
            this.arN = com.baidu.tbadk.core.sharedPref.b.um().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.arN)) {
            com.baidu.tbadk.core.sharedPref.b.um().putInt("KeyOfSharedPrefImCount", By + 1);
        } else {
            this.arN = null;
        }
        return this.arN;
    }

    public void eY(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.arN = str;
            com.baidu.tbadk.core.sharedPref.b.um().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> BA() {
        if (this.arO == null) {
            this.arO = eZ(com.baidu.tbadk.core.sharedPref.b.um().getString("KeyOfSharedPrefIpList", null));
        }
        return this.arO;
    }

    public void BB() {
        this.arQ = false;
    }

    public boolean BC() {
        return this.arQ;
    }

    public void a(InterfaceC0039a interfaceC0039a) {
        if (this.arP == null) {
            this.arQ = true;
            this.arP = new b(interfaceC0039a);
            this.arP.setSelfExecute(true);
            this.arP.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eZ(String str) {
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
        private volatile z ajm = null;
        private InterfaceC0039a arR;

        public b(InterfaceC0039a interfaceC0039a) {
            this.arR = null;
            this.arR = interfaceC0039a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.ajm = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String uy = this.ajm.uy();
                if (this.ajm.uW().vS().oH() && uy != null) {
                    JSONObject jSONObject = new JSONObject(uy);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.arO = a.this.eZ(optString);
                        if (a.this.arO != null && a.this.arO.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.arO.size(); i2++) {
                                String str2 = (String) a.this.arO.get(i2);
                                h hVar = new h();
                                hVar.fc(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.BP()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.arO = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.arO.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.um().putString("KeyOfSharedPrefIpList", str);
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
            a.this.arP = null;
            if (this.arR != null) {
                this.arR.BD();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.arP = null;
            if (this.arR != null) {
                this.arR.BD();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.arP = null;
            if (this.arR != null) {
                this.arR.BD();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ajm != null) {
                this.ajm.eg();
                this.ajm = null;
            }
            a.this.arP = null;
            super.cancel(true);
        }
    }
}
