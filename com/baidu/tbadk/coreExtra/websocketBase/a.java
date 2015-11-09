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
    private String ams;
    private List<String> amt;
    private b amu;
    private boolean amv;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a {
        void zy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a amz = new a(null);
    }

    public static a zs() {
        return c.amz;
    }

    private a() {
        this.ams = null;
        this.amt = null;
        this.amu = null;
        this.amv = false;
        this.amv = false;
        this.amt = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int zt() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String zu() {
        int zt = zt();
        if (zt >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tu().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tu().putString("KeyOfSharedPrefValidIp", "");
            this.ams = null;
            return null;
        }
        if (this.ams == null) {
            this.ams = com.baidu.tbadk.core.sharedPref.b.tu().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.ams)) {
            com.baidu.tbadk.core.sharedPref.b.tu().putInt("KeyOfSharedPrefImCount", zt + 1);
        } else {
            this.ams = null;
        }
        return this.ams;
    }

    public void ey(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.ams = str;
            com.baidu.tbadk.core.sharedPref.b.tu().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> zv() {
        if (this.amt == null) {
            this.amt = ez(com.baidu.tbadk.core.sharedPref.b.tu().getString("KeyOfSharedPrefIpList", null));
        }
        return this.amt;
    }

    public void zw() {
        this.amv = false;
    }

    public boolean zx() {
        return this.amv;
    }

    public void a(InterfaceC0044a interfaceC0044a) {
        if (this.amu == null) {
            this.amv = true;
            this.amu = new b(interfaceC0044a);
            this.amu.setSelfExecute(true);
            this.amu.execute(new Object[0]);
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
        private volatile w afm = null;
        private InterfaceC0044a amw;

        public b(InterfaceC0044a interfaceC0044a) {
            this.amw = null;
            this.amw = interfaceC0044a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.afm = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String tG = this.afm.tG();
                if (this.afm.uh().va().qT() && tG != null) {
                    JSONObject jSONObject = new JSONObject(tG);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.amt = a.this.ez(optString);
                        if (a.this.amt != null && a.this.amt.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.amt.size(); i2++) {
                                String str2 = (String) a.this.amt.get(i2);
                                h hVar = new h();
                                hVar.eC(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.zJ()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.amt = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.amt.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.tu().putString("KeyOfSharedPrefIpList", str);
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
            a.this.amu = null;
            if (this.amw != null) {
                this.amw.zy();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.amu = null;
            if (this.amw != null) {
                this.amw.zy();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.amu = null;
            if (this.amw != null) {
                this.amw.zy();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afm != null) {
                this.afm.gJ();
                this.afm = null;
            }
            a.this.amu = null;
            super.cancel(true);
        }
    }
}
