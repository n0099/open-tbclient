package com.baidu.tbadk.coreExtra.e;

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
    private String cfL;
    private List<String> cfM;
    private b cfN;
    private boolean cfO;

    /* renamed from: com.baidu.tbadk.coreExtra.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0230a {
        void akP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a cfS = new a();
    }

    public static a akJ() {
        return c.cfS;
    }

    private a() {
        this.cfL = null;
        this.cfM = null;
        this.cfN = null;
        this.cfO = false;
        this.cfO = false;
        this.cfM = null;
    }

    public int akK() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String akL() {
        int akK = akK();
        if (akK >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.cfL = null;
            return null;
        }
        if (this.cfL == null) {
            this.cfL = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.cfL)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", akK + 1);
        } else {
            this.cfL = null;
        }
        return this.cfL;
    }

    public void oo(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.cfL = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> akM() {
        if (this.cfM == null) {
            this.cfM = op(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.cfM;
    }

    public void akN() {
        this.cfO = false;
    }

    public boolean akO() {
        return this.cfO;
    }

    public void a(InterfaceC0230a interfaceC0230a) {
        if (this.cfN == null) {
            this.cfO = true;
            this.cfN = new b(interfaceC0230a);
            this.cfN.setSelfExecute(true);
            this.cfN.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> op(String str) {
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
        private InterfaceC0230a cfP;
        private volatile x mNetwork = null;

        public b(InterfaceC0230a interfaceC0230a) {
            this.cfP = null;
            this.cfP = interfaceC0230a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String acj = this.mNetwork.acj();
                if (this.mNetwork.acH().adG().isRequestSuccess() && acj != null) {
                    JSONObject jSONObject = new JSONObject(acj);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.cfM = a.this.op(optString);
                        if (a.this.cfM != null && a.this.cfM.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.cfM.size(); i++) {
                                String str2 = (String) a.this.cfM.get(i);
                                f fVar = new f();
                                fVar.os(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.ala()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.cfM = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.e.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.l(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.l(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.cfM.add(entry.getKey());
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
        public void onPostExecute(Void r3) {
            a.this.cfN = null;
            if (this.cfP != null) {
                this.cfP.akP();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.cfN = null;
            if (this.cfP != null) {
                this.cfP.akP();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.cfN = null;
            if (this.cfP != null) {
                this.cfP.akP();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            a.this.cfN = null;
            super.cancel(true);
        }
    }
}
