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
    private String awh;
    private List<String> awi;
    private b awj;
    private boolean awk;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0037a {
        void Cc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a awo = new a(null);
    }

    public static a BW() {
        return c.awo;
    }

    private a() {
        this.awh = null;
        this.awi = null;
        this.awj = null;
        this.awk = false;
        this.awk = false;
        this.awi = null;
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
            this.awh = null;
            return null;
        }
        if (this.awh == null) {
            this.awh = com.baidu.tbadk.core.sharedPref.b.uL().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.awh)) {
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("KeyOfSharedPrefImCount", BX + 1);
        } else {
            this.awh = null;
        }
        return this.awh;
    }

    public void eM(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.awh = str;
            com.baidu.tbadk.core.sharedPref.b.uL().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> BZ() {
        if (this.awi == null) {
            this.awi = eN(com.baidu.tbadk.core.sharedPref.b.uL().getString("KeyOfSharedPrefIpList", null));
        }
        return this.awi;
    }

    public void Ca() {
        this.awk = false;
    }

    public boolean Cb() {
        return this.awk;
    }

    public void a(InterfaceC0037a interfaceC0037a) {
        if (this.awj == null) {
            this.awk = true;
            this.awj = new b(interfaceC0037a);
            this.awj.setSelfExecute(true);
            this.awj.execute(new Object[0]);
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
        private InterfaceC0037a awl;
        private volatile z mNetwork = null;

        public b(InterfaceC0037a interfaceC0037a) {
            this.awl = null;
            this.awl = interfaceC0037a;
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
                        a.this.awi = a.this.eN(optString);
                        if (a.this.awi != null && a.this.awi.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.awi.size(); i2++) {
                                String str2 = (String) a.this.awi.get(i2);
                                h hVar = new h();
                                hVar.eQ(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.Co()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.awi = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.awi.add((String) entry.getKey());
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
            a.this.awj = null;
            if (this.awl != null) {
                this.awl.Cc();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onCancelled(Void r3) {
            a.this.awj = null;
            if (this.awl != null) {
                this.awl.Cc();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.awj = null;
            if (this.awl != null) {
                this.awl.Cc();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fr();
                this.mNetwork = null;
            }
            a.this.awj = null;
            super.cancel(true);
        }
    }
}
