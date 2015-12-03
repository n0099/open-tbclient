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
    private String aof;
    private List<String> aog;
    private b aoh;
    private boolean aoi;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046a {
        void Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aom = new a(null);
    }

    public static a Ao() {
        return c.aom;
    }

    private a() {
        this.aof = null;
        this.aog = null;
        this.aoh = null;
        this.aoi = false;
        this.aoi = false;
        this.aog = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int Ap() {
        return com.baidu.tbadk.core.sharedPref.b.tZ().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String Aq() {
        int Ap = Ap();
        if (Ap >= 10) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.tZ().putString("KeyOfSharedPrefValidIp", "");
            this.aof = null;
            return null;
        }
        if (this.aof == null) {
            this.aof = com.baidu.tbadk.core.sharedPref.b.tZ().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.aof)) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt("KeyOfSharedPrefImCount", Ap + 1);
        } else {
            this.aof = null;
        }
        return this.aof;
    }

    public void eI(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aof = str;
            com.baidu.tbadk.core.sharedPref.b.tZ().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Ar() {
        if (this.aog == null) {
            this.aog = eJ(com.baidu.tbadk.core.sharedPref.b.tZ().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aog;
    }

    public void As() {
        this.aoi = false;
    }

    public boolean At() {
        return this.aoi;
    }

    public void a(InterfaceC0046a interfaceC0046a) {
        if (this.aoh == null) {
            this.aoi = true;
            this.aoh = new b(interfaceC0046a);
            this.aoh.setSelfExecute(true);
            this.aoh.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eJ(String str) {
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
        private volatile ab agS = null;
        private InterfaceC0046a aoj;

        public b(InterfaceC0046a interfaceC0046a) {
            this.aoj = null;
            this.aoj = interfaceC0046a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.agS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String ul = this.agS.ul();
                if (this.agS.uM().vG().rf() && ul != null) {
                    JSONObject jSONObject = new JSONObject(ul);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aog = a.this.eJ(optString);
                        if (a.this.aog != null && a.this.aog.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.aog.size(); i2++) {
                                String str2 = (String) a.this.aog.get(i2);
                                h hVar = new h();
                                hVar.eM(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.AG()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aog = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.aog.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.tZ().putString("KeyOfSharedPrefIpList", str);
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
            a.this.aoh = null;
            if (this.aoj != null) {
                this.aoj.Au();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.aoh = null;
            if (this.aoj != null) {
                this.aoj.Au();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aoh = null;
            if (this.aoj != null) {
                this.aoj.Au();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.agS != null) {
                this.agS.gL();
                this.agS = null;
            }
            a.this.aoh = null;
            super.cancel(true);
        }
    }
}
