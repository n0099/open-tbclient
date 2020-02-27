package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
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
    private String duk;
    private List<String> dul;
    private b dum;
    private boolean dun;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0382a {
        void aNl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a dur = new a();
    }

    public static a aNg() {
        return c.dur;
    }

    private a() {
        this.duk = null;
        this.dul = null;
        this.dum = null;
        this.dun = false;
        this.dun = false;
        this.dul = null;
    }

    public int aNh() {
        return com.baidu.tbadk.core.sharedPref.b.aFB().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String aNi() {
        int aNh = aNh();
        if (aNh >= 10) {
            com.baidu.tbadk.core.sharedPref.b.aFB().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.aFB().putString("KeyOfSharedPrefValidIp", "");
            this.duk = null;
            return null;
        }
        if (this.duk == null) {
            this.duk = com.baidu.tbadk.core.sharedPref.b.aFB().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.duk)) {
            com.baidu.tbadk.core.sharedPref.b.aFB().putInt("KeyOfSharedPrefImCount", aNh + 1);
        } else {
            this.duk = null;
        }
        return this.duk;
    }

    public void uI(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.duk = str;
            com.baidu.tbadk.core.sharedPref.b.aFB().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.dul == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aFB().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.aFB().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.dul = uJ(com.baidu.tbadk.core.sharedPref.b.aFB().getString("KeyOfSharedPrefIpList", null));
        }
        return this.dul;
    }

    public void aNj() {
        this.dun = false;
    }

    public boolean aNk() {
        return this.dun;
    }

    public void a(InterfaceC0382a interfaceC0382a) {
        if (this.dum == null) {
            this.dun = true;
            this.dum = new b(interfaceC0382a);
            this.dum.setSelfExecute(true);
            this.dum.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> uJ(String str) {
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
        private InterfaceC0382a duo;
        private volatile x mNetwork = null;

        public b(InterfaceC0382a interfaceC0382a) {
            this.duo = null;
            this.duo = interfaceC0382a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aGe().aGG().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.dul = a.this.uJ(optString);
                        if (a.this.dul != null && a.this.dul.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.dul.size(); i++) {
                                String str2 = (String) a.this.dul.get(i);
                                f fVar = new f();
                                fVar.uM(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.aNt()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.dul = new ArrayList();
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
                                    a.this.dul.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.aFB().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.aFB().putString("KeyOfSharedPrefIpList", str);
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
            a.this.dum = null;
            if (this.duo != null) {
                this.duo.aNl();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.dum = null;
            if (this.duo != null) {
                this.duo.aNl();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.dum = null;
            if (this.duo != null) {
                this.duo.aNl();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.dum = null;
            super.cancel(true);
        }
    }
}
