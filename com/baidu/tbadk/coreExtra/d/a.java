package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String frL;
    private List<String> frM;
    private b frN;
    private boolean frO;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0596a {
        void bBh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a frS = new a();
    }

    public static a bBc() {
        return c.frS;
    }

    private a() {
        this.frL = null;
        this.frM = null;
        this.frN = null;
        this.frO = false;
        this.frO = false;
        this.frM = null;
    }

    public int bBd() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bBe() {
        int bBd = bBd();
        if (bBd >= 10) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.bsO().putString("KeyOfSharedPrefValidIp", "");
            this.frL = null;
            return null;
        }
        if (this.frL == null) {
            this.frL = com.baidu.tbadk.core.sharedPref.b.bsO().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.frL)) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("KeyOfSharedPrefImCount", bBd + 1);
        } else {
            this.frL = null;
        }
        return this.frL;
    }

    public void Ds(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.frL = str;
            com.baidu.tbadk.core.sharedPref.b.bsO().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.frM == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bsO().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.frM = Dt(com.baidu.tbadk.core.sharedPref.b.bsO().getString("KeyOfSharedPrefIpList", null));
        }
        return this.frM;
    }

    public void bBf() {
        this.frO = false;
    }

    public boolean bBg() {
        return this.frO;
    }

    public void a(InterfaceC0596a interfaceC0596a) {
        if (this.frN == null) {
            this.frO = true;
            this.frN = new b(interfaceC0596a);
            this.frN.setSelfExecute(true);
            this.frN.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> Dt(String str) {
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
        private InterfaceC0596a frP;
        private volatile aa mNetwork = null;

        public b(InterfaceC0596a interfaceC0596a) {
            this.frP = null;
            this.frP = interfaceC0596a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.btv().buf().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.frM = a.this.Dt(optString);
                        if (a.this.frM != null && a.this.frM.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.frM.size(); i++) {
                                String str2 = (String) a.this.frM.get(i);
                                f fVar = new f();
                                fVar.Dw(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bBp()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.frM = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.d.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.f.b.toInt(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.f.b.toInt(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.frM.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.bsO().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.bsO().putString("KeyOfSharedPrefIpList", str);
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
            a.this.frN = null;
            if (this.frP != null) {
                this.frP.bBh();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.frN = null;
            if (this.frP != null) {
                this.frP.bBh();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.frN = null;
            if (this.frP != null) {
                this.frP.bBh();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.frN = null;
            super.cancel(true);
        }
    }
}
