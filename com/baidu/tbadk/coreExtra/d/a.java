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
    private String fyY;
    private List<String> fyZ;
    private b fza;
    private boolean fzb;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0567a {
        void bAb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a fzf = new a();
    }

    public static a bzV() {
        return c.fzf;
    }

    private a() {
        this.fyY = null;
        this.fyZ = null;
        this.fza = null;
        this.fzb = false;
        this.fzb = false;
        this.fyZ = null;
    }

    public int bzW() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bzX() {
        int bzW = bzW();
        if (bzW >= 10) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("KeyOfSharedPrefValidIp", "");
            this.fyY = null;
            return null;
        }
        if (this.fyY == null) {
            this.fyY = com.baidu.tbadk.core.sharedPref.b.brQ().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.fyY)) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("KeyOfSharedPrefImCount", bzW + 1);
        } else {
            this.fyY = null;
        }
        return this.fyY;
    }

    public void Cv(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.fyY = str;
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> bzY() {
        if (this.fyZ == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brQ().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.fyZ = Cw(com.baidu.tbadk.core.sharedPref.b.brQ().getString("KeyOfSharedPrefIpList", null));
        }
        return this.fyZ;
    }

    public void bzZ() {
        this.fzb = false;
    }

    public boolean bAa() {
        return this.fzb;
    }

    public void a(InterfaceC0567a interfaceC0567a) {
        if (this.fza == null) {
            this.fzb = true;
            this.fza = new b(interfaceC0567a);
            this.fza.setSelfExecute(true);
            this.fza.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> Cw(String str) {
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
        private InterfaceC0567a fzc;
        private volatile aa mNetwork = null;

        public b(InterfaceC0567a interfaceC0567a) {
            this.fzc = null;
            this.fzc = interfaceC0567a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bsr().btb().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.fyZ = a.this.Cw(optString);
                        if (a.this.fyZ != null && a.this.fyZ.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.fyZ.size(); i++) {
                                String str2 = (String) a.this.fyZ.get(i);
                                f fVar = new f();
                                fVar.Cz(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.bAj()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.fyZ = new ArrayList();
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
                                    a.this.fyZ.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.brQ().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.brQ().putString("KeyOfSharedPrefIpList", str);
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
            a.this.fza = null;
            if (this.fzc != null) {
                this.fzc.bAb();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.fza = null;
            if (this.fzc != null) {
                this.fzc.bAb();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.fza = null;
            if (this.fzc != null) {
                this.fzc.bAb();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.fza = null;
            super.cancel(true);
        }
    }
}
