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
    private String ari;
    private List<String> arj;
    private b ark;
    private boolean arl;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039a {
        void Bs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a arp = new a(null);
    }

    public static a Bm() {
        return c.arp;
    }

    private a() {
        this.ari = null;
        this.arj = null;
        this.ark = null;
        this.arl = false;
        this.arl = false;
        this.arj = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Bn() {
        return com.baidu.tbadk.core.sharedPref.b.tS().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Bo() {
        int Bn = Bn();
        if (Bn >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tS().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tS().putString("KeyOfSharedPrefValidIp", "");
            this.ari = null;
            return null;
        }
        if (this.ari == null) {
            this.ari = com.baidu.tbadk.core.sharedPref.b.tS().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.ari)) {
            com.baidu.tbadk.core.sharedPref.b.tS().putInt("KeyOfSharedPrefImCount", Bn + 1);
        } else {
            this.ari = null;
        }
        return this.ari;
    }

    public void eT(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.ari = str;
            com.baidu.tbadk.core.sharedPref.b.tS().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Bp() {
        if (this.arj == null) {
            this.arj = eU(com.baidu.tbadk.core.sharedPref.b.tS().getString("KeyOfSharedPrefIpList", null));
        }
        return this.arj;
    }

    public void Bq() {
        this.arl = false;
    }

    public boolean Br() {
        return this.arl;
    }

    public void a(InterfaceC0039a interfaceC0039a) {
        if (this.ark == null) {
            this.arl = true;
            this.ark = new b(interfaceC0039a);
            this.ark.setSelfExecute(true);
            this.ark.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eU(String str) {
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
        private volatile ab aiS = null;
        private InterfaceC0039a arm;

        public b(InterfaceC0039a interfaceC0039a) {
            this.arm = null;
            this.arm = interfaceC0039a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.aiS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String ue = this.aiS.ue();
                if (this.aiS.uD().vA().oE() && ue != null) {
                    JSONObject jSONObject = new JSONObject(ue);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.arj = a.this.eU(optString);
                        if (a.this.arj != null && a.this.arj.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.arj.size(); i2++) {
                                String str2 = (String) a.this.arj.get(i2);
                                h hVar = new h();
                                hVar.eX(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.BE()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.arj = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.arj.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.tS().putString("KeyOfSharedPrefIpList", str);
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
            a.this.ark = null;
            if (this.arm != null) {
                this.arm.Bs();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.ark = null;
            if (this.arm != null) {
                this.arm.Bs();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.ark = null;
            if (this.arm != null) {
                this.arm.Bs();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiS != null) {
                this.aiS.eg();
                this.aiS = null;
            }
            a.this.ark = null;
            super.cancel(true);
        }
    }
}
