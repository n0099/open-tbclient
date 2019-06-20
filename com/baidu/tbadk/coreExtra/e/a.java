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
    private String cnW;
    private List<String> cnX;
    private b cnY;
    private boolean cnZ;

    /* renamed from: com.baidu.tbadk.coreExtra.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0245a {
        void apP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a cod = new a();
    }

    public static a apJ() {
        return c.cod;
    }

    private a() {
        this.cnW = null;
        this.cnX = null;
        this.cnY = null;
        this.cnZ = false;
        this.cnZ = false;
        this.cnX = null;
    }

    public int apK() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String apL() {
        int apK = apK();
        if (apK >= 10) {
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.agM().putString("KeyOfSharedPrefValidIp", "");
            this.cnW = null;
            return null;
        }
        if (this.cnW == null) {
            this.cnW = com.baidu.tbadk.core.sharedPref.b.agM().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.cnW)) {
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("KeyOfSharedPrefImCount", apK + 1);
        } else {
            this.cnW = null;
        }
        return this.cnW;
    }

    public void pw(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.cnW = str;
            com.baidu.tbadk.core.sharedPref.b.agM().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> apM() {
        if (this.cnX == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.agM().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.agM().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.cnX = px(com.baidu.tbadk.core.sharedPref.b.agM().getString("KeyOfSharedPrefIpList", null));
        }
        return this.cnX;
    }

    public void apN() {
        this.cnZ = false;
    }

    public boolean apO() {
        return this.cnZ;
    }

    public void a(InterfaceC0245a interfaceC0245a) {
        if (this.cnY == null) {
            this.cnZ = true;
            this.cnY = new b(interfaceC0245a);
            this.cnY.setSelfExecute(true);
            this.cnY.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> px(String str) {
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
        private InterfaceC0245a coa;
        private volatile x mNetwork = null;

        public b(InterfaceC0245a interfaceC0245a) {
            this.coa = null;
            this.coa = interfaceC0245a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String ahe = this.mNetwork.ahe();
                if (this.mNetwork.ahC().aiC().isRequestSuccess() && ahe != null) {
                    JSONObject jSONObject = new JSONObject(ahe);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.cnX = a.this.px(optString);
                        if (a.this.cnX != null && a.this.cnX.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.cnX.size(); i++) {
                                String str2 = (String) a.this.cnX.get(i);
                                f fVar = new f();
                                fVar.pA(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.aqa()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.cnX = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.e.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.f(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.f(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.cnX.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.agM().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.agM().putString("KeyOfSharedPrefIpList", str);
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
            a.this.cnY = null;
            if (this.coa != null) {
                this.coa.apP();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.cnY = null;
            if (this.coa != null) {
                this.coa.apP();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.cnY = null;
            if (this.coa != null) {
                this.coa.apP();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ia();
                this.mNetwork = null;
            }
            a.this.cnY = null;
            super.cancel(true);
        }
    }
}
