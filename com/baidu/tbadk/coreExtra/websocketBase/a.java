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
    private String anK;
    private List<String> anL;
    private b anM;
    private boolean anN;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a {
        void zH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a anR = new a(null);
    }

    public static a zB() {
        return c.anR;
    }

    private a() {
        this.anK = null;
        this.anL = null;
        this.anM = null;
        this.anN = false;
        this.anN = false;
        this.anL = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int zC() {
        return com.baidu.tbadk.core.sharedPref.b.tx().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String zD() {
        int zC = zC();
        if (zC >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tx().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tx().putString("KeyOfSharedPrefValidIp", "");
            this.anK = null;
            return null;
        }
        if (this.anK == null) {
            this.anK = com.baidu.tbadk.core.sharedPref.b.tx().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.anK)) {
            com.baidu.tbadk.core.sharedPref.b.tx().putInt("KeyOfSharedPrefImCount", zC + 1);
        } else {
            this.anK = null;
        }
        return this.anK;
    }

    public void eu(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.anK = str;
            com.baidu.tbadk.core.sharedPref.b.tx().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> zE() {
        if (this.anL == null) {
            this.anL = ev(com.baidu.tbadk.core.sharedPref.b.tx().getString("KeyOfSharedPrefIpList", null));
        }
        return this.anL;
    }

    public void zF() {
        this.anN = false;
    }

    public boolean zG() {
        return this.anN;
    }

    public void a(InterfaceC0044a interfaceC0044a) {
        if (this.anM == null) {
            this.anN = true;
            this.anM = new b(interfaceC0044a);
            this.anM.setSelfExecute(true);
            this.anM.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> ev(String str) {
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
        private volatile v afT = null;
        private InterfaceC0044a anO;

        public b(InterfaceC0044a interfaceC0044a) {
            this.anO = null;
            this.anO = interfaceC0044a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.afT = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String tI = this.afT.tI();
                if (this.afT.uj().va().qZ() && tI != null) {
                    JSONObject jSONObject = new JSONObject(tI);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.anL = a.this.ev(optString);
                        if (a.this.anL != null && a.this.anL.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.anL.size(); i2++) {
                                String str2 = (String) a.this.anL.get(i2);
                                h hVar = new h();
                                hVar.ey(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.zS()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.anL = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.anL.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.tx().putString("KeyOfSharedPrefIpList", str);
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
            a.this.anM = null;
            if (this.anO != null) {
                this.anO.zH();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.anM = null;
            if (this.anO != null) {
                this.anO.zH();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.anM = null;
            if (this.anO != null) {
                this.anO.zH();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afT != null) {
                this.afT.gJ();
                this.afT = null;
            }
            a.this.anM = null;
            super.cancel(true);
        }
    }
}
