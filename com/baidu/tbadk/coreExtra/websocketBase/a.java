package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String bpF;
    private List<String> bpG;
    private b bpH;
    private boolean bpI;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0104a {
        void JX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a bpM = new a();
    }

    public static a JR() {
        return c.bpM;
    }

    private a() {
        this.bpF = null;
        this.bpG = null;
        this.bpH = null;
        this.bpI = false;
        this.bpI = false;
        this.bpG = null;
    }

    public int JS() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String JT() {
        int JS = JS();
        if (JS >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.bpF = null;
            return null;
        }
        if (this.bpF == null) {
            this.bpF = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.bpF)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", JS + 1);
        } else {
            this.bpF = null;
        }
        return this.bpF;
    }

    public void fQ(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.bpF = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> JU() {
        if (this.bpG == null) {
            this.bpG = fR(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.bpG;
    }

    public void JV() {
        this.bpI = false;
    }

    public boolean JW() {
        return this.bpI;
    }

    public void a(InterfaceC0104a interfaceC0104a) {
        if (this.bpH == null) {
            this.bpI = true;
            this.bpH = new b(interfaceC0104a);
            this.bpH.setSelfExecute(true);
            this.bpH.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> fR(String str) {
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

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<Object, Integer, Void> {
        private InterfaceC0104a bpJ;
        private volatile x mNetwork = null;

        public b(InterfaceC0104a interfaceC0104a) {
            this.bpJ = null;
            this.bpJ = interfaceC0104a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String Cb = this.mNetwork.Cb();
                if (this.mNetwork.Cz().Dx().isRequestSuccess() && Cb != null) {
                    JSONObject jSONObject = new JSONObject(Cb);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.bpG = a.this.fR(optString);
                        if (a.this.bpG != null && a.this.bpG.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.bpG.size(); i++) {
                                String str2 = (String) a.this.bpG.get(i);
                                e eVar = new e();
                                eVar.fU(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.Kj()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.bpG = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.websocketBase.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.h(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.h(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.bpG.add(entry.getKey());
                                    if (i2 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        /* renamed from: a */
        public void onPostExecute(Void r3) {
            a.this.bpH = null;
            if (this.bpJ != null) {
                this.bpJ.JX();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onCancelled(Void r3) {
            a.this.bpH = null;
            if (this.bpJ != null) {
                this.bpJ.JX();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.bpH = null;
            if (this.bpJ != null) {
                this.bpJ.JX();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
                this.mNetwork = null;
            }
            a.this.bpH = null;
            super.cancel(true);
        }
    }
}
