package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aqT;
    private List<String> aqU;
    private b aqV;
    private boolean aqW;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039a {
        void Bw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a ara = new a(null);
    }

    public static a Bq() {
        return c.ara;
    }

    private a() {
        this.aqT = null;
        this.aqU = null;
        this.aqV = null;
        this.aqW = false;
        this.aqW = false;
        this.aqU = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Br() {
        return com.baidu.tbadk.core.sharedPref.b.uh().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Bs() {
        int Br = Br();
        if (Br >= 10) {
            com.baidu.tbadk.core.sharedPref.b.uh().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.uh().putString("KeyOfSharedPrefValidIp", "");
            this.aqT = null;
            return null;
        }
        if (this.aqT == null) {
            this.aqT = com.baidu.tbadk.core.sharedPref.b.uh().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.aqT)) {
            com.baidu.tbadk.core.sharedPref.b.uh().putInt("KeyOfSharedPrefImCount", Br + 1);
        } else {
            this.aqT = null;
        }
        return this.aqT;
    }

    public void eW(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aqT = str;
            com.baidu.tbadk.core.sharedPref.b.uh().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Bt() {
        if (this.aqU == null) {
            this.aqU = eX(com.baidu.tbadk.core.sharedPref.b.uh().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aqU;
    }

    public void Bu() {
        this.aqW = false;
    }

    public boolean Bv() {
        return this.aqW;
    }

    public void a(InterfaceC0039a interfaceC0039a) {
        if (this.aqV == null) {
            this.aqW = true;
            this.aqV = new b(interfaceC0039a);
            this.aqV.setSelfExecute(true);
            this.aqV.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eX(String str) {
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
        private volatile ab aiu = null;
        private InterfaceC0039a aqX;

        public b(InterfaceC0039a interfaceC0039a) {
            this.aqX = null;
            this.aqX = interfaceC0039a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.aiu = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String uu = this.aiu.uu();
                if (this.aiu.uS().vO().oF() && uu != null) {
                    JSONObject jSONObject = new JSONObject(uu);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aqU = a.this.eX(optString);
                        if (a.this.aqU != null && a.this.aqU.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.aqU.size(); i2++) {
                                String str2 = (String) a.this.aqU.get(i2);
                                h hVar = new h();
                                hVar.fa(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.BI()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aqU = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.aqU.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.uh().putString("KeyOfSharedPrefIpList", str);
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
            a.this.aqV = null;
            if (this.aqX != null) {
                this.aqX.Bw();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.aqV = null;
            if (this.aqX != null) {
                this.aqX.Bw();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aqV = null;
            if (this.aqX != null) {
                this.aqX.Bw();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiu != null) {
                this.aiu.eg();
                this.aiu = null;
            }
            a.this.aqV = null;
            super.cancel(true);
        }
    }
}
