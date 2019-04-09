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
    private String cfO;
    private List<String> cfP;
    private b cfQ;
    private boolean cfR;

    /* renamed from: com.baidu.tbadk.coreExtra.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0230a {
        void akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a cfV = new a();
    }

    public static a akG() {
        return c.cfV;
    }

    private a() {
        this.cfO = null;
        this.cfP = null;
        this.cfQ = null;
        this.cfR = false;
        this.cfR = false;
        this.cfP = null;
    }

    public int akH() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String akI() {
        int akH = akH();
        if (akH >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.cfO = null;
            return null;
        }
        if (this.cfO == null) {
            this.cfO = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.cfO)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", akH + 1);
        } else {
            this.cfO = null;
        }
        return this.cfO;
    }

    public void op(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.cfO = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> akJ() {
        if (this.cfP == null) {
            this.cfP = oq(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.cfP;
    }

    public void akK() {
        this.cfR = false;
    }

    public boolean akL() {
        return this.cfR;
    }

    public void a(InterfaceC0230a interfaceC0230a) {
        if (this.cfQ == null) {
            this.cfR = true;
            this.cfQ = new b(interfaceC0230a);
            this.cfQ.setSelfExecute(true);
            this.cfQ.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> oq(String str) {
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
        private InterfaceC0230a cfS;
        private volatile x mNetwork = null;

        public b(InterfaceC0230a interfaceC0230a) {
            this.cfS = null;
            this.cfS = interfaceC0230a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String acg = this.mNetwork.acg();
                if (this.mNetwork.acE().adD().isRequestSuccess() && acg != null) {
                    JSONObject jSONObject = new JSONObject(acg);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.cfP = a.this.oq(optString);
                        if (a.this.cfP != null && a.this.cfP.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.cfP.size(); i++) {
                                String str2 = (String) a.this.cfP.get(i);
                                f fVar = new f();
                                fVar.ot(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.akX()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.cfP = new ArrayList();
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
                                    a.this.cfP.add(entry.getKey());
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
            a.this.cfQ = null;
            if (this.cfS != null) {
                this.cfS.akM();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.cfQ = null;
            if (this.cfS != null) {
                this.cfS.akM();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.cfQ = null;
            if (this.cfS != null) {
                this.cfS.akM();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            a.this.cfQ = null;
            super.cancel(true);
        }
    }
}
