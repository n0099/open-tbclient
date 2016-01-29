package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aqB;
    private List<String> aqC;
    private b aqD;
    private boolean aqE;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a {
        void BA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aqI = new a(null);
    }

    public static a Bu() {
        return c.aqI;
    }

    private a() {
        this.aqB = null;
        this.aqC = null;
        this.aqD = null;
        this.aqE = false;
        this.aqE = false;
        this.aqC = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Bv() {
        return com.baidu.tbadk.core.sharedPref.b.uO().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Bw() {
        int Bv = Bv();
        if (Bv >= 10) {
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.uO().putString("KeyOfSharedPrefValidIp", "");
            this.aqB = null;
            return null;
        }
        if (this.aqB == null) {
            this.aqB = com.baidu.tbadk.core.sharedPref.b.uO().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.aqB)) {
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("KeyOfSharedPrefImCount", Bv + 1);
        } else {
            this.aqB = null;
        }
        return this.aqB;
    }

    public void eK(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aqB = str;
            com.baidu.tbadk.core.sharedPref.b.uO().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Bx() {
        if (this.aqC == null) {
            this.aqC = eL(com.baidu.tbadk.core.sharedPref.b.uO().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aqC;
    }

    public void By() {
        this.aqE = false;
    }

    public boolean Bz() {
        return this.aqE;
    }

    public void a(InterfaceC0047a interfaceC0047a) {
        if (this.aqD == null) {
            this.aqE = true;
            this.aqD = new b(interfaceC0047a);
            this.aqD.setSelfExecute(true);
            this.aqD.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eL(String str) {
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
        private volatile aa aiG = null;
        private InterfaceC0047a aqF;

        public b(InterfaceC0047a interfaceC0047a) {
            this.aqF = null;
            this.aqF = interfaceC0047a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.aiG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String uZ = this.aiG.uZ();
                if (this.aiG.vB().ww().rl() && uZ != null) {
                    JSONObject jSONObject = new JSONObject(uZ);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aqC = a.this.eL(optString);
                        if (a.this.aqC != null && a.this.aqC.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.aqC.size(); i2++) {
                                String str2 = (String) a.this.aqC.get(i2);
                                h hVar = new h();
                                hVar.eO(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.BM()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aqC = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.aqC.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.uO().putString("KeyOfSharedPrefIpList", str);
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
            a.this.aqD = null;
            if (this.aqF != null) {
                this.aqF.BA();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.aqD = null;
            if (this.aqF != null) {
                this.aqF.BA();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aqD = null;
            if (this.aqF != null) {
                this.aqF.BA();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiG != null) {
                this.aiG.gT();
                this.aiG = null;
            }
            a.this.aqD = null;
            super.cancel(true);
        }
    }
}
