package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aob;
    private List<String> aoc;
    private b aod;
    private boolean aoe;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039a {
        void Ad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aoi = new a(null);
    }

    public static a zX() {
        return c.aoi;
    }

    private a() {
        this.aob = null;
        this.aoc = null;
        this.aod = null;
        this.aoe = false;
        this.aoe = false;
        this.aoc = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int zY() {
        return com.baidu.tbadk.core.sharedPref.b.sN().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String zZ() {
        int zY = zY();
        if (zY >= 10) {
            com.baidu.tbadk.core.sharedPref.b.sN().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.sN().putString("KeyOfSharedPrefValidIp", "");
            this.aob = null;
            return null;
        }
        if (this.aob == null) {
            this.aob = com.baidu.tbadk.core.sharedPref.b.sN().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.aob)) {
            com.baidu.tbadk.core.sharedPref.b.sN().putInt("KeyOfSharedPrefImCount", zY + 1);
        } else {
            this.aob = null;
        }
        return this.aob;
    }

    public void eQ(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aob = str;
            com.baidu.tbadk.core.sharedPref.b.sN().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Aa() {
        if (this.aoc == null) {
            this.aoc = eR(com.baidu.tbadk.core.sharedPref.b.sN().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aoc;
    }

    public void Ab() {
        this.aoe = false;
    }

    public boolean Ac() {
        return this.aoe;
    }

    public void a(InterfaceC0039a interfaceC0039a) {
        if (this.aod == null) {
            this.aoe = true;
            this.aod = new b(interfaceC0039a);
            this.aod.setSelfExecute(true);
            this.aod.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eR(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, Void> {
        private volatile ab afX = null;
        private InterfaceC0039a aof;

        public b(InterfaceC0039a interfaceC0039a) {
            this.aof = null;
            this.aof = interfaceC0039a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.afX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String sZ = this.afX.sZ();
                if (this.afX.tx().uv().nJ() && sZ != null) {
                    JSONObject jSONObject = new JSONObject(sZ);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aoc = a.this.eR(optString);
                        if (a.this.aoc != null && a.this.aoc.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.aoc.size(); i2++) {
                                String str2 = (String) a.this.aoc.get(i2);
                                h hVar = new h();
                                hVar.eU(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.Ap()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aoc = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.aoc.add((String) entry.getKey());
                                    if (i != 0) {
                                        sb.append(",");
                                    }
                                    int i3 = i + 1;
                                    sb.append((String) entry.getKey());
                                    i = i3;
                                }
                                str = sb.toString();
                            } else {
                                str = optString;
                            }
                            com.baidu.tbadk.core.sharedPref.b.sN().putString("KeyOfSharedPrefIpList", str);
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
        /* renamed from: b */
        public void onPostExecute(Void r3) {
            a.this.aod = null;
            if (this.aof != null) {
                this.aof.Ad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.aod = null;
            if (this.aof != null) {
                this.aof.Ad();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aod = null;
            if (this.aof != null) {
                this.aof.Ad();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afX != null) {
                this.afX.dl();
                this.afX = null;
            }
            a.this.aod = null;
            super.cancel(true);
        }
    }
}
