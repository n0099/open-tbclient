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
    private String awj;
    private List<String> awk;
    private b awl;
    private boolean awm;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0037a {
        void Cc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a awq = new a(null);
    }

    public static a BW() {
        return c.awq;
    }

    private a() {
        this.awj = null;
        this.awk = null;
        this.awl = null;
        this.awm = false;
        this.awm = false;
        this.awk = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int BX() {
        return com.baidu.tbadk.core.sharedPref.b.uL().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String BY() {
        int BX = BX();
        if (BX >= 10) {
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.uL().putString("KeyOfSharedPrefValidIp", "");
            this.awj = null;
            return null;
        }
        if (this.awj == null) {
            this.awj = com.baidu.tbadk.core.sharedPref.b.uL().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.awj)) {
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("KeyOfSharedPrefImCount", BX + 1);
        } else {
            this.awj = null;
        }
        return this.awj;
    }

    public void eM(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.awj = str;
            com.baidu.tbadk.core.sharedPref.b.uL().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> BZ() {
        if (this.awk == null) {
            this.awk = eN(com.baidu.tbadk.core.sharedPref.b.uL().getString("KeyOfSharedPrefIpList", null));
        }
        return this.awk;
    }

    public void Ca() {
        this.awm = false;
    }

    public boolean Cb() {
        return this.awm;
    }

    public void a(InterfaceC0037a interfaceC0037a) {
        if (this.awl == null) {
            this.awm = true;
            this.awl = new b(interfaceC0037a);
            this.awl.setSelfExecute(true);
            this.awl.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eN(String str) {
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
        private InterfaceC0037a awn;
        private volatile z mNetwork = null;

        public b(InterfaceC0037a interfaceC0037a) {
            this.awn = null;
            this.awn = interfaceC0037a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String uY = this.mNetwork.uY();
                if (this.mNetwork.vw().wq().isRequestSuccess() && uY != null) {
                    JSONObject jSONObject = new JSONObject(uY);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.awk = a.this.eN(optString);
                        if (a.this.awk != null && a.this.awk.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.awk.size(); i2++) {
                                String str2 = (String) a.this.awk.get(i2);
                                h hVar = new h();
                                hVar.eQ(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.Co()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.awk = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.awk.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.uL().putString("KeyOfSharedPrefIpList", str);
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
            a.this.awl = null;
            if (this.awn != null) {
                this.awn.Cc();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onCancelled(Void r3) {
            a.this.awl = null;
            if (this.awn != null) {
                this.awn.Cc();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.awl = null;
            if (this.awn != null) {
                this.awn.Cc();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fs();
                this.mNetwork = null;
            }
            a.this.awl = null;
            super.cancel(true);
        }
    }
}
