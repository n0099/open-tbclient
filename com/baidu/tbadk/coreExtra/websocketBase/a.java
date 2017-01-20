package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aqw;
    private List<String> aqx;
    private b aqy;
    private boolean aqz;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039a {
        void Bl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aqD = new a(null);
    }

    public static a Bf() {
        return c.aqD;
    }

    private a() {
        this.aqw = null;
        this.aqx = null;
        this.aqy = null;
        this.aqz = false;
        this.aqz = false;
        this.aqx = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Bg() {
        return com.baidu.tbadk.core.sharedPref.b.tQ().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Bh() {
        int Bg = Bg();
        if (Bg >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tQ().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tQ().putString("KeyOfSharedPrefValidIp", "");
            this.aqw = null;
            return null;
        }
        if (this.aqw == null) {
            this.aqw = com.baidu.tbadk.core.sharedPref.b.tQ().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.aqw)) {
            com.baidu.tbadk.core.sharedPref.b.tQ().putInt("KeyOfSharedPrefImCount", Bg + 1);
        } else {
            this.aqw = null;
        }
        return this.aqw;
    }

    public void eR(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aqw = str;
            com.baidu.tbadk.core.sharedPref.b.tQ().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Bi() {
        if (this.aqx == null) {
            this.aqx = eS(com.baidu.tbadk.core.sharedPref.b.tQ().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aqx;
    }

    public void Bj() {
        this.aqz = false;
    }

    public boolean Bk() {
        return this.aqz;
    }

    public void a(InterfaceC0039a interfaceC0039a) {
        if (this.aqy == null) {
            this.aqz = true;
            this.aqy = new b(interfaceC0039a);
            this.aqy.setSelfExecute(true);
            this.aqy.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eS(String str) {
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
        private InterfaceC0039a aqA;
        private volatile y mNetwork = null;

        public b(InterfaceC0039a interfaceC0039a) {
            this.aqA = null;
            this.aqA = interfaceC0039a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.mNetwork = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String ud = this.mNetwork.ud();
                if (this.mNetwork.uC().vw().isRequestSuccess() && ud != null) {
                    JSONObject jSONObject = new JSONObject(ud);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aqx = a.this.eS(optString);
                        if (a.this.aqx != null && a.this.aqx.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.aqx.size(); i2++) {
                                String str2 = (String) a.this.aqx.get(i2);
                                h hVar = new h();
                                hVar.eV(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.Bx()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aqx = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.aqx.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.tQ().putString("KeyOfSharedPrefIpList", str);
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
            a.this.aqy = null;
            if (this.aqA != null) {
                this.aqA.Bl();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.aqy = null;
            if (this.aqA != null) {
                this.aqA.Bl();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aqy = null;
            if (this.aqA != null) {
                this.aqA.Bl();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ee();
                this.mNetwork = null;
            }
            a.this.aqy = null;
            super.cancel(true);
        }
    }
}
