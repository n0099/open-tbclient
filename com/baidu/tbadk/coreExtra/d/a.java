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
    private String fld;
    private List<String> fle;
    private b flf;
    private boolean flg;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0584a {
        void byr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a flk = new a();
    }

    public static a bym() {
        return c.flk;
    }

    private a() {
        this.fld = null;
        this.fle = null;
        this.flf = null;
        this.flg = false;
        this.flg = false;
        this.fle = null;
    }

    public int byn() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String byo() {
        int byn = byn();
        if (byn >= 10) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.bqh().putString("KeyOfSharedPrefValidIp", "");
            this.fld = null;
            return null;
        }
        if (this.fld == null) {
            this.fld = com.baidu.tbadk.core.sharedPref.b.bqh().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.fld)) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt("KeyOfSharedPrefImCount", byn + 1);
        } else {
            this.fld = null;
        }
        return this.fld;
    }

    public void Dl(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.fld = str;
            com.baidu.tbadk.core.sharedPref.b.bqh().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.fle == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bqh().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.fle = Dm(com.baidu.tbadk.core.sharedPref.b.bqh().getString("KeyOfSharedPrefIpList", null));
        }
        return this.fle;
    }

    public void byp() {
        this.flg = false;
    }

    public boolean byq() {
        return this.flg;
    }

    public void a(InterfaceC0584a interfaceC0584a) {
        if (this.flf == null) {
            this.flg = true;
            this.flf = new b(interfaceC0584a);
            this.flf.setSelfExecute(true);
            this.flf.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> Dm(String str) {
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
        private InterfaceC0584a flh;
        private volatile aa mNetwork = null;

        public b(InterfaceC0584a interfaceC0584a) {
            this.flh = null;
            this.flh = interfaceC0584a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bqN().bru().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.fle = a.this.Dm(optString);
                        if (a.this.fle != null && a.this.fle.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.fle.size(); i++) {
                                String str2 = (String) a.this.fle.get(i);
                                f fVar = new f();
                                fVar.Dp(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.byz()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.fle = new ArrayList();
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
                                    a.this.fle.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.bqh().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.bqh().putString("KeyOfSharedPrefIpList", str);
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
            a.this.flf = null;
            if (this.flh != null) {
                this.flh.byr();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.flf = null;
            if (this.flh != null) {
                this.flh.byr();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.flf = null;
            if (this.flh != null) {
                this.flh.byr();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.flf = null;
            super.cancel(true);
        }
    }
}
