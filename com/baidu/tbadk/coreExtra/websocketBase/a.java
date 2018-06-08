package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aIA;
    private List<String> aIB;
    private b aIC;
    private boolean aID;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0110a {
        void Ge();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aIH = new a();
    }

    public static a FY() {
        return c.aIH;
    }

    private a() {
        this.aIA = null;
        this.aIB = null;
        this.aIC = null;
        this.aID = false;
        this.aID = false;
        this.aIB = null;
    }

    public int FZ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Ga() {
        int FZ = FZ();
        if (FZ >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.aIA = null;
            return null;
        }
        if (this.aIA == null) {
            this.aIA = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.aIA)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", FZ + 1);
        } else {
            this.aIA = null;
        }
        return this.aIA;
    }

    public void gf(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aIA = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Gb() {
        if (this.aIB == null) {
            this.aIB = gg(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aIB;
    }

    public void Gc() {
        this.aID = false;
    }

    public boolean Gd() {
        return this.aID;
    }

    public void a(InterfaceC0110a interfaceC0110a) {
        if (this.aIC == null) {
            this.aID = true;
            this.aIC = new b(interfaceC0110a);
            this.aIC.setSelfExecute(true);
            this.aIC.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> gg(String str) {
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

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<Object, Integer, Void> {
        private InterfaceC0110a aIE;
        private volatile y mNetwork = null;

        public b(InterfaceC0110a interfaceC0110a) {
            this.aIE = null;
            this.aIE = interfaceC0110a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String yl = this.mNetwork.yl();
                if (this.mNetwork.yJ().zJ().isRequestSuccess() && yl != null) {
                    JSONObject jSONObject = new JSONObject(yl);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aIB = a.this.gg(optString);
                        if (a.this.aIB != null && a.this.aIB.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.aIB.size(); i++) {
                                String str2 = (String) a.this.aIB.get(i);
                                e eVar = new e();
                                eVar.gj(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.Gq()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aIB = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.websocketBase.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.g(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.g(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.aIB.add(entry.getKey());
                                    if (i2 != 0) {
                                        sb.append(",");
                                    }
                                    i2++;
                                    sb.append((String) entry.getKey());
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
            a.this.aIC = null;
            if (this.aIE != null) {
                this.aIE.Ge();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.aIC = null;
            if (this.aIE != null) {
                this.aIE.Ge();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aIC = null;
            if (this.aIE != null) {
                this.aIE.Ge();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            a.this.aIC = null;
            super.cancel(true);
        }
    }
}
