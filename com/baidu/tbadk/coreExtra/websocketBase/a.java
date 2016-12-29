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
    private String arq;
    private List<String> arr;
    private b ars;
    private boolean art;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039a {
        void Bq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a arx = new a(null);
    }

    public static a Bk() {
        return c.arx;
    }

    private a() {
        this.arq = null;
        this.arr = null;
        this.ars = null;
        this.art = false;
        this.art = false;
        this.arr = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Bl() {
        return com.baidu.tbadk.core.sharedPref.b.tW().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Bm() {
        int Bl = Bl();
        if (Bl >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tW().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tW().putString("KeyOfSharedPrefValidIp", "");
            this.arq = null;
            return null;
        }
        if (this.arq == null) {
            this.arq = com.baidu.tbadk.core.sharedPref.b.tW().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.arq)) {
            com.baidu.tbadk.core.sharedPref.b.tW().putInt("KeyOfSharedPrefImCount", Bl + 1);
        } else {
            this.arq = null;
        }
        return this.arq;
    }

    public void eU(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.arq = str;
            com.baidu.tbadk.core.sharedPref.b.tW().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Bn() {
        if (this.arr == null) {
            this.arr = eV(com.baidu.tbadk.core.sharedPref.b.tW().getString("KeyOfSharedPrefIpList", null));
        }
        return this.arr;
    }

    public void Bo() {
        this.art = false;
    }

    public boolean Bp() {
        return this.art;
    }

    public void a(InterfaceC0039a interfaceC0039a) {
        if (this.ars == null) {
            this.art = true;
            this.ars = new b(interfaceC0039a);
            this.ars.setSelfExecute(true);
            this.ars.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eV(String str) {
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
        private volatile z aiN = null;
        private InterfaceC0039a aru;

        public b(InterfaceC0039a interfaceC0039a) {
            this.aru = null;
            this.aru = interfaceC0039a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.aiN = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String uk = this.aiN.uk();
                if (this.aiN.uI().vC().oH() && uk != null) {
                    JSONObject jSONObject = new JSONObject(uk);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.arr = a.this.eV(optString);
                        if (a.this.arr != null && a.this.arr.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.arr.size(); i2++) {
                                String str2 = (String) a.this.arr.get(i2);
                                h hVar = new h();
                                hVar.eY(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.BC()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.arr = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.arr.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.tW().putString("KeyOfSharedPrefIpList", str);
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
            a.this.ars = null;
            if (this.aru != null) {
                this.aru.Bq();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.ars = null;
            if (this.aru != null) {
                this.aru.Bq();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.ars = null;
            if (this.aru != null) {
                this.aru.Bq();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiN != null) {
                this.aiN.eg();
                this.aiN = null;
            }
            a.this.ars = null;
            super.cancel(true);
        }
    }
}
