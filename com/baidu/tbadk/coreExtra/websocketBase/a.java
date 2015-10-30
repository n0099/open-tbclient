package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String amn;
    private List<String> amo;
    private b amp;
    private boolean amq;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a {
        void zt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a amu = new a(null);
    }

    public static a zn() {
        return c.amu;
    }

    private a() {
        this.amn = null;
        this.amo = null;
        this.amp = null;
        this.amq = false;
        this.amq = false;
        this.amo = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int zo() {
        return com.baidu.tbadk.core.sharedPref.b.tr().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String zp() {
        int zo = zo();
        if (zo >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tr().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tr().putString("KeyOfSharedPrefValidIp", "");
            this.amn = null;
            return null;
        }
        if (this.amn == null) {
            this.amn = com.baidu.tbadk.core.sharedPref.b.tr().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.amn)) {
            com.baidu.tbadk.core.sharedPref.b.tr().putInt("KeyOfSharedPrefImCount", zo + 1);
        } else {
            this.amn = null;
        }
        return this.amn;
    }

    public void ey(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.amn = str;
            com.baidu.tbadk.core.sharedPref.b.tr().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> zq() {
        if (this.amo == null) {
            this.amo = ez(com.baidu.tbadk.core.sharedPref.b.tr().getString("KeyOfSharedPrefIpList", null));
        }
        return this.amo;
    }

    public void zr() {
        this.amq = false;
    }

    public boolean zs() {
        return this.amq;
    }

    public void a(InterfaceC0044a interfaceC0044a) {
        if (this.amp == null) {
            this.amq = true;
            this.amp = new b(interfaceC0044a);
            this.amp.setSelfExecute(true);
            this.amp.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> ez(String str) {
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
        private volatile w afh = null;
        private InterfaceC0044a amr;

        public b(InterfaceC0044a interfaceC0044a) {
            this.amr = null;
            this.amr = interfaceC0044a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.afh = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String tD = this.afh.tD();
                if (this.afh.ue().uW().qS() && tD != null) {
                    JSONObject jSONObject = new JSONObject(tD);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.amo = a.this.ez(optString);
                        if (a.this.amo != null && a.this.amo.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.amo.size(); i2++) {
                                String str2 = (String) a.this.amo.get(i2);
                                h hVar = new h();
                                hVar.eC(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.zE()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.amo = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.amo.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.tr().putString("KeyOfSharedPrefIpList", str);
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
            a.this.amp = null;
            if (this.amr != null) {
                this.amr.zt();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.amp = null;
            if (this.amr != null) {
                this.amr.zt();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.amp = null;
            if (this.amr != null) {
                this.amr.zt();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afh != null) {
                this.afh.gJ();
                this.afh = null;
            }
            a.this.amp = null;
            super.cancel(true);
        }
    }
}
