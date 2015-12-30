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
    private String apJ;
    private List<String> apK;
    private b apL;
    private boolean apM;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046a {
        void Ak();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a apQ = new a(null);
    }

    public static a Ae() {
        return c.apQ;
    }

    private a() {
        this.apJ = null;
        this.apK = null;
        this.apL = null;
        this.apM = false;
        this.apM = false;
        this.apK = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Af() {
        return com.baidu.tbadk.core.sharedPref.b.tJ().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Ag() {
        int Af = Af();
        if (Af >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tJ().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tJ().putString("KeyOfSharedPrefValidIp", "");
            this.apJ = null;
            return null;
        }
        if (this.apJ == null) {
            this.apJ = com.baidu.tbadk.core.sharedPref.b.tJ().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.apJ)) {
            com.baidu.tbadk.core.sharedPref.b.tJ().putInt("KeyOfSharedPrefImCount", Af + 1);
        } else {
            this.apJ = null;
        }
        return this.apJ;
    }

    public void eL(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.apJ = str;
            com.baidu.tbadk.core.sharedPref.b.tJ().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Ah() {
        if (this.apK == null) {
            this.apK = eM(com.baidu.tbadk.core.sharedPref.b.tJ().getString("KeyOfSharedPrefIpList", null));
        }
        return this.apK;
    }

    public void Ai() {
        this.apM = false;
    }

    public boolean Aj() {
        return this.apM;
    }

    public void a(InterfaceC0046a interfaceC0046a) {
        if (this.apL == null) {
            this.apM = true;
            this.apL = new b(interfaceC0046a);
            this.apL.setSelfExecute(true);
            this.apL.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eM(String str) {
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
        private volatile ab ahV = null;
        private InterfaceC0046a apN;

        public b(InterfaceC0046a interfaceC0046a) {
            this.apN = null;
            this.apN = interfaceC0046a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.ahV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String tV = this.ahV.tV();
                if (this.ahV.uw().vq().qO() && tV != null) {
                    JSONObject jSONObject = new JSONObject(tV);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.apK = a.this.eM(optString);
                        if (a.this.apK != null && a.this.apK.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.apK.size(); i2++) {
                                String str2 = (String) a.this.apK.get(i2);
                                h hVar = new h();
                                hVar.eP(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.Aw()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.apK = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.apK.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.tJ().putString("KeyOfSharedPrefIpList", str);
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
            a.this.apL = null;
            if (this.apN != null) {
                this.apN.Ak();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.apL = null;
            if (this.apN != null) {
                this.apN.Ak();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.apL = null;
            if (this.apN != null) {
                this.apN.Ak();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ahV != null) {
                this.ahV.gL();
                this.ahV = null;
            }
            a.this.apL = null;
            super.cancel(true);
        }
    }
}
