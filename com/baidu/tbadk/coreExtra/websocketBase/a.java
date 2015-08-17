package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String alY;
    private List<String> alZ;
    private b ama;
    private boolean amb;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a {
        void zu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a amf = new a(null);
    }

    public static a zo() {
        return c.amf;
    }

    private a() {
        this.alY = null;
        this.alZ = null;
        this.ama = null;
        this.amb = false;
        this.amb = false;
        this.alZ = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int zp() {
        return com.baidu.tbadk.core.sharedPref.b.ts().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String zq() {
        int zp = zp();
        if (zp >= 10) {
            com.baidu.tbadk.core.sharedPref.b.ts().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.ts().putString("KeyOfSharedPrefValidIp", "");
            this.alY = null;
            return null;
        }
        if (this.alY == null) {
            this.alY = com.baidu.tbadk.core.sharedPref.b.ts().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.alY)) {
            com.baidu.tbadk.core.sharedPref.b.ts().putInt("KeyOfSharedPrefImCount", zp + 1);
        } else {
            this.alY = null;
        }
        return this.alY;
    }

    public void em(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.alY = str;
            com.baidu.tbadk.core.sharedPref.b.ts().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> zr() {
        if (this.alZ == null) {
            this.alZ = en(com.baidu.tbadk.core.sharedPref.b.ts().getString("KeyOfSharedPrefIpList", null));
        }
        return this.alZ;
    }

    public void zs() {
        this.amb = false;
    }

    public boolean zt() {
        return this.amb;
    }

    public void a(InterfaceC0044a interfaceC0044a) {
        if (this.ama == null) {
            this.amb = true;
            this.ama = new b(interfaceC0044a);
            this.ama.setSelfExecute(true);
            this.ama.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> en(String str) {
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
        private volatile v afJ = null;
        private InterfaceC0044a amc;

        public b(InterfaceC0044a interfaceC0044a) {
            this.amc = null;
            this.amc = interfaceC0044a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.afJ = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String tD = this.afJ.tD();
                if (this.afJ.ue().uW().rb() && tD != null) {
                    JSONObject jSONObject = new JSONObject(tD);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.alZ = a.this.en(optString);
                        if (a.this.alZ != null && a.this.alZ.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.alZ.size(); i2++) {
                                String str2 = (String) a.this.alZ.get(i2);
                                h hVar = new h();
                                hVar.eq(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.zF()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.alZ = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.alZ.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.ts().putString("KeyOfSharedPrefIpList", str);
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
            a.this.ama = null;
            if (this.amc != null) {
                this.amc.zu();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.ama = null;
            if (this.amc != null) {
                this.amc.zu();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.ama = null;
            if (this.amc != null) {
                this.amc.zu();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afJ != null) {
                this.afJ.gM();
                this.afJ = null;
            }
            a.this.ama = null;
            super.cancel(true);
        }
    }
}
