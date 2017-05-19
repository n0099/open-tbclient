package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
    private String awn;
    private List<String> awo;
    private b awp;
    private boolean awq;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0041a {
        void Bn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a awu = new a(null);
    }

    public static a Bh() {
        return c.awu;
    }

    private a() {
        this.awn = null;
        this.awo = null;
        this.awp = null;
        this.awq = false;
        this.awq = false;
        this.awo = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Bi() {
        return com.baidu.tbadk.core.sharedPref.b.tX().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Bj() {
        int Bi = Bi();
        if (Bi >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tX().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tX().putString("KeyOfSharedPrefValidIp", "");
            this.awn = null;
            return null;
        }
        if (this.awn == null) {
            this.awn = com.baidu.tbadk.core.sharedPref.b.tX().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.awn)) {
            com.baidu.tbadk.core.sharedPref.b.tX().putInt("KeyOfSharedPrefImCount", Bi + 1);
        } else {
            this.awn = null;
        }
        return this.awn;
    }

    public void eL(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.awn = str;
            com.baidu.tbadk.core.sharedPref.b.tX().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Bk() {
        if (this.awo == null) {
            this.awo = eM(com.baidu.tbadk.core.sharedPref.b.tX().getString("KeyOfSharedPrefIpList", null));
        }
        return this.awo;
    }

    public void Bl() {
        this.awq = false;
    }

    public boolean Bm() {
        return this.awq;
    }

    public void a(InterfaceC0041a interfaceC0041a) {
        if (this.awp == null) {
            this.awq = true;
            this.awp = new b(interfaceC0041a);
            this.awp.setSelfExecute(true);
            this.awp.execute(new Object[0]);
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
        private InterfaceC0041a awr;
        private volatile z mNetwork = null;

        public b(InterfaceC0041a interfaceC0041a) {
            this.awr = null;
            this.awr = interfaceC0041a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String ul = this.mNetwork.ul();
                if (this.mNetwork.uJ().vE().isRequestSuccess() && ul != null) {
                    JSONObject jSONObject = new JSONObject(ul);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.awo = a.this.eM(optString);
                        if (a.this.awo != null && a.this.awo.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.awo.size(); i2++) {
                                String str2 = (String) a.this.awo.get(i2);
                                h hVar = new h();
                                hVar.eP(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.Bz()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.awo = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.awo.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.tX().putString("KeyOfSharedPrefIpList", str);
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
            a.this.awp = null;
            if (this.awr != null) {
                this.awr.Bn();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onCancelled(Void r3) {
            a.this.awp = null;
            if (this.awr != null) {
                this.awr.Bn();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.awp = null;
            if (this.awr != null) {
                this.awr.Bn();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fs();
                this.mNetwork = null;
            }
            a.this.awp = null;
            super.cancel(true);
        }
    }
}
