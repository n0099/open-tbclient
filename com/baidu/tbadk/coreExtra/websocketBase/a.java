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
    private String aqS;
    private List<String> aqT;
    private b aqU;
    private boolean aqV;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a {
        void Cd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aqZ = new a(null);
    }

    public static a BX() {
        return c.aqZ;
    }

    private a() {
        this.aqS = null;
        this.aqT = null;
        this.aqU = null;
        this.aqV = false;
        this.aqV = false;
        this.aqT = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int BY() {
        return com.baidu.tbadk.core.sharedPref.b.vk().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String BZ() {
        int BY = BY();
        if (BY >= 10) {
            com.baidu.tbadk.core.sharedPref.b.vk().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.vk().putString("KeyOfSharedPrefValidIp", "");
            this.aqS = null;
            return null;
        }
        if (this.aqS == null) {
            this.aqS = com.baidu.tbadk.core.sharedPref.b.vk().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.aqS)) {
            com.baidu.tbadk.core.sharedPref.b.vk().putInt("KeyOfSharedPrefImCount", BY + 1);
        } else {
            this.aqS = null;
        }
        return this.aqS;
    }

    public void eR(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aqS = str;
            com.baidu.tbadk.core.sharedPref.b.vk().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Ca() {
        if (this.aqT == null) {
            this.aqT = eS(com.baidu.tbadk.core.sharedPref.b.vk().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aqT;
    }

    public void Cb() {
        this.aqV = false;
    }

    public boolean Cc() {
        return this.aqV;
    }

    public void a(InterfaceC0047a interfaceC0047a) {
        if (this.aqU == null) {
            this.aqV = true;
            this.aqU = new b(interfaceC0047a);
            this.aqU.setSelfExecute(true);
            this.aqU.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eS(String str) {
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
        private volatile ab aiW = null;
        private InterfaceC0047a aqW;

        public b(InterfaceC0047a interfaceC0047a) {
            this.aqW = null;
            this.aqW = interfaceC0047a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.aiW = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String vw = this.aiW.vw();
                if (this.aiW.vU().wP().qC() && vw != null) {
                    JSONObject jSONObject = new JSONObject(vw);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aqT = a.this.eS(optString);
                        if (a.this.aqT != null && a.this.aqT.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.aqT.size(); i2++) {
                                String str2 = (String) a.this.aqT.get(i2);
                                h hVar = new h();
                                hVar.eV(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.Cp()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aqT = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.aqT.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.vk().putString("KeyOfSharedPrefIpList", str);
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
            a.this.aqU = null;
            if (this.aqW != null) {
                this.aqW.Cd();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.aqU = null;
            if (this.aqW != null) {
                this.aqW.Cd();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aqU = null;
            if (this.aqW != null) {
                this.aqW.Cd();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiW != null) {
                this.aiW.gX();
                this.aiW = null;
            }
            a.this.aqU = null;
            super.cancel(true);
        }
    }
}
