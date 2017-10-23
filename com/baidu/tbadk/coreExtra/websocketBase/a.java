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
    private String axC;
    private List<String> axD;
    private b axE;
    private boolean axF;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0053a {
        void Bm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a axJ = new a();
    }

    public static a Bg() {
        return c.axJ;
    }

    private a() {
        this.axC = null;
        this.axD = null;
        this.axE = null;
        this.axF = false;
        this.axF = false;
        this.axD = null;
    }

    public int Bh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Bi() {
        int Bh = Bh();
        if (Bh >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.axC = null;
            return null;
        }
        if (this.axC == null) {
            this.axC = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.axC)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", Bh + 1);
        } else {
            this.axC = null;
        }
        return this.axC;
    }

    public void fe(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.axC = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Bj() {
        if (this.axD == null) {
            this.axD = ff(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.axD;
    }

    public void Bk() {
        this.axF = false;
    }

    public boolean Bl() {
        return this.axF;
    }

    public void a(InterfaceC0053a interfaceC0053a) {
        if (this.axE == null) {
            this.axF = true;
            this.axE = new b(interfaceC0053a);
            this.axE.setSelfExecute(true);
            this.axE.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> ff(String str) {
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
        private InterfaceC0053a axG;
        private volatile x mNetwork = null;

        public b(InterfaceC0053a interfaceC0053a) {
            this.axG = null;
            this.axG = interfaceC0053a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String ui = this.mNetwork.ui();
                if (this.mNetwork.uG().vD().isRequestSuccess() && ui != null) {
                    JSONObject jSONObject = new JSONObject(ui);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.axD = a.this.ff(optString);
                        if (a.this.axD != null && a.this.axD.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.axD.size(); i++) {
                                String str2 = (String) a.this.axD.get(i);
                                e eVar = new e();
                                eVar.fi(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.By()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.axD = new ArrayList();
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
                                    a.this.axD.add(entry.getKey());
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
            a.this.axE = null;
            if (this.axG != null) {
                this.axG.Bm();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onCancelled(Void r3) {
            a.this.axE = null;
            if (this.axG != null) {
                this.axG.Bm();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.axE = null;
            if (this.axG != null) {
                this.axG.Bm();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
                this.mNetwork = null;
            }
            a.this.axE = null;
            super.cancel(true);
        }
    }
}
