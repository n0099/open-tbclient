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
    private String amm;
    private List<String> amn;
    private b amo;
    private boolean amp;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a {
        void zw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a amt = new a(null);
    }

    public static a zq() {
        return c.amt;
    }

    private a() {
        this.amm = null;
        this.amn = null;
        this.amo = null;
        this.amp = false;
        this.amp = false;
        this.amn = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int zr() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String zs() {
        int zr = zr();
        if (zr >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tu().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tu().putString("KeyOfSharedPrefValidIp", "");
            this.amm = null;
            return null;
        }
        if (this.amm == null) {
            this.amm = com.baidu.tbadk.core.sharedPref.b.tu().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.amm)) {
            com.baidu.tbadk.core.sharedPref.b.tu().putInt("KeyOfSharedPrefImCount", zr + 1);
        } else {
            this.amm = null;
        }
        return this.amm;
    }

    public void ey(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.amm = str;
            com.baidu.tbadk.core.sharedPref.b.tu().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> zt() {
        if (this.amn == null) {
            this.amn = ez(com.baidu.tbadk.core.sharedPref.b.tu().getString("KeyOfSharedPrefIpList", null));
        }
        return this.amn;
    }

    public void zu() {
        this.amp = false;
    }

    public boolean zv() {
        return this.amp;
    }

    public void a(InterfaceC0044a interfaceC0044a) {
        if (this.amo == null) {
            this.amp = true;
            this.amo = new b(interfaceC0044a);
            this.amo.setSelfExecute(true);
            this.amo.execute(new Object[0]);
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
        private volatile w afg = null;
        private InterfaceC0044a amq;

        public b(InterfaceC0044a interfaceC0044a) {
            this.amq = null;
            this.amq = interfaceC0044a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.afg = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String tG = this.afg.tG();
                if (this.afg.uh().uY().qV() && tG != null) {
                    JSONObject jSONObject = new JSONObject(tG);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.amn = a.this.ez(optString);
                        if (a.this.amn != null && a.this.amn.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.amn.size(); i2++) {
                                String str2 = (String) a.this.amn.get(i2);
                                h hVar = new h();
                                hVar.eC(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.zH()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.amn = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.amn.add((String) entry.getKey());
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
            a.this.amo = null;
            if (this.amq != null) {
                this.amq.zw();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.amo = null;
            if (this.amq != null) {
                this.amq.zw();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.amo = null;
            if (this.amq != null) {
                this.amq.zw();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afg != null) {
                this.afg.gJ();
                this.afg = null;
            }
            a.this.amo = null;
            super.cancel(true);
        }
    }
}
