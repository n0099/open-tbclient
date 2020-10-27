package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
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
    private String ffk;
    private List<String> ffl;
    private b ffm;
    private boolean ffn;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0572a {
        void bvS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a ffr = new a();
    }

    public static a bvN() {
        return c.ffr;
    }

    private a() {
        this.ffk = null;
        this.ffl = null;
        this.ffm = null;
        this.ffn = false;
        this.ffn = false;
        this.ffl = null;
    }

    public int bvO() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bvP() {
        int bvO = bvO();
        if (bvO >= 10) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.bnH().putString("KeyOfSharedPrefValidIp", "");
            this.ffk = null;
            return null;
        }
        if (this.ffk == null) {
            this.ffk = com.baidu.tbadk.core.sharedPref.b.bnH().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.ffk)) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt("KeyOfSharedPrefImCount", bvO + 1);
        } else {
            this.ffk = null;
        }
        return this.ffk;
    }

    public void CX(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.ffk = str;
            com.baidu.tbadk.core.sharedPref.b.bnH().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.ffl == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bnH().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.ffl = CY(com.baidu.tbadk.core.sharedPref.b.bnH().getString("KeyOfSharedPrefIpList", null));
        }
        return this.ffl;
    }

    public void bvQ() {
        this.ffn = false;
    }

    public boolean bvR() {
        return this.ffn;
    }

    public void a(InterfaceC0572a interfaceC0572a) {
        if (this.ffm == null) {
            this.ffn = true;
            this.ffm = new b(interfaceC0572a);
            this.ffm.setSelfExecute(true);
            this.ffm.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> CY(String str) {
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
        private InterfaceC0572a ffo;
        private volatile aa mNetwork = null;

        public b(InterfaceC0572a interfaceC0572a) {
            this.ffo = null;
            this.ffo = interfaceC0572a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bon().boU().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.ffl = a.this.CY(optString);
                        if (a.this.ffl != null && a.this.ffl.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.ffl.size(); i++) {
                                String str2 = (String) a.this.ffl.get(i);
                                f fVar = new f();
                                fVar.Db(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bwa()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.ffl = new ArrayList();
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
                                    a.this.ffl.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.bnH().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.bnH().putString("KeyOfSharedPrefIpList", str);
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
            a.this.ffm = null;
            if (this.ffo != null) {
                this.ffo.bvS();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.ffm = null;
            if (this.ffo != null) {
                this.ffo.bvS();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.ffm = null;
            if (this.ffo != null) {
                this.ffo.bvS();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.ffm = null;
            super.cancel(true);
        }
    }
}
