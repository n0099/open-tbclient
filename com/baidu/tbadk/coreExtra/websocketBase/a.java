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
    private String amG;
    private List<String> amH;
    private b amI;
    private boolean amJ;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0038a {
        void zY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a amN = new a(null);
    }

    public static a zS() {
        return c.amN;
    }

    private a() {
        this.amG = null;
        this.amH = null;
        this.amI = null;
        this.amJ = false;
        this.amJ = false;
        this.amH = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int zT() {
        return com.baidu.tbadk.core.sharedPref.b.sR().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String zU() {
        int zT = zT();
        if (zT >= 10) {
            com.baidu.tbadk.core.sharedPref.b.sR().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.sR().putString("KeyOfSharedPrefValidIp", "");
            this.amG = null;
            return null;
        }
        if (this.amG == null) {
            this.amG = com.baidu.tbadk.core.sharedPref.b.sR().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.amG)) {
            com.baidu.tbadk.core.sharedPref.b.sR().putInt("KeyOfSharedPrefImCount", zT + 1);
        } else {
            this.amG = null;
        }
        return this.amG;
    }

    public void eO(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.amG = str;
            com.baidu.tbadk.core.sharedPref.b.sR().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> zV() {
        if (this.amH == null) {
            this.amH = eP(com.baidu.tbadk.core.sharedPref.b.sR().getString("KeyOfSharedPrefIpList", null));
        }
        return this.amH;
    }

    public void zW() {
        this.amJ = false;
    }

    public boolean zX() {
        return this.amJ;
    }

    public void a(InterfaceC0038a interfaceC0038a) {
        if (this.amI == null) {
            this.amJ = true;
            this.amI = new b(interfaceC0038a);
            this.amI.setSelfExecute(true);
            this.amI.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eP(String str) {
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
        private volatile ab aeI = null;
        private InterfaceC0038a amK;

        public b(InterfaceC0038a interfaceC0038a) {
            this.amK = null;
            this.amK = interfaceC0038a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.aeI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String td = this.aeI.td();
                if (this.aeI.tB().uw().nZ() && td != null) {
                    JSONObject jSONObject = new JSONObject(td);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.amH = a.this.eP(optString);
                        if (a.this.amH != null && a.this.amH.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.amH.size(); i2++) {
                                String str2 = (String) a.this.amH.get(i2);
                                h hVar = new h();
                                hVar.eS(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.Ak()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.amH = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.amH.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.sR().putString("KeyOfSharedPrefIpList", str);
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
            a.this.amI = null;
            if (this.amK != null) {
                this.amK.zY();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.amI = null;
            if (this.amK != null) {
                this.amK.zY();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.amI = null;
            if (this.amK != null) {
                this.amK.zY();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
                this.aeI = null;
            }
            a.this.amI = null;
            super.cancel(true);
        }
    }
}
