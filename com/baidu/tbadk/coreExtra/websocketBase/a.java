package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String axa;
    private List<String> axb;
    private b axc;
    private boolean axd;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0043a {
        void BB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a axh = new a(null);
    }

    public static a Bv() {
        return c.axh;
    }

    private a() {
        this.axa = null;
        this.axb = null;
        this.axc = null;
        this.axd = false;
        this.axd = false;
        this.axb = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Bw() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Bx() {
        int Bw = Bw();
        if (Bw >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.axa = null;
            return null;
        }
        if (this.axa == null) {
            this.axa = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.axa)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", Bw + 1);
        } else {
            this.axa = null;
        }
        return this.axa;
    }

    public void fd(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.axa = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> By() {
        if (this.axb == null) {
            this.axb = fe(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.axb;
    }

    public void Bz() {
        this.axd = false;
    }

    public boolean BA() {
        return this.axd;
    }

    public void a(InterfaceC0043a interfaceC0043a) {
        if (this.axc == null) {
            this.axd = true;
            this.axc = new b(interfaceC0043a);
            this.axc.setSelfExecute(true);
            this.axc.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> fe(String str) {
        String[] split;
        ArrayList arrayList = null;
        if (str != null && str.length() > 0 && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length > 0) {
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
        private InterfaceC0043a axe;
        private volatile ab mNetwork = null;

        public b(InterfaceC0043a interfaceC0043a) {
            this.axe = null;
            this.axe = interfaceC0043a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.mNetwork = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String uy = this.mNetwork.uy();
                if (this.mNetwork.uV().vS().isRequestSuccess() && uy != null) {
                    JSONObject jSONObject = new JSONObject(uy);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.axb = a.this.fe(optString);
                        if (a.this.axb != null && a.this.axb.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.axb.size(); i2++) {
                                String str2 = (String) a.this.axb.get(i2);
                                h hVar = new h();
                                hVar.fh(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.BN()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.axb = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.axb.add((String) entry.getKey());
                                    if (i != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    int i3 = i + 1;
                                    sb.append((String) entry.getKey());
                                    i = i3;
                                }
                                str = sb.toString();
                            } else {
                                str = optString;
                            }
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefIpList", str);
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
        public void onPostExecute(Void r3) {
            a.this.axc = null;
            if (this.axe != null) {
                this.axe.BB();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onCancelled(Void r3) {
            a.this.axc = null;
            if (this.axe != null) {
                this.axe.BB();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.axc = null;
            if (this.axe != null) {
                this.axe.BB();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fr();
                this.mNetwork = null;
            }
            a.this.axc = null;
            super.cancel(true);
        }
    }
}
