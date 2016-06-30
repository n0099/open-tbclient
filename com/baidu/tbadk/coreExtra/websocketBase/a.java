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
    private String anm;
    private List<String> ann;
    private b ano;
    private boolean anp;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0038a {
        void Ad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a ant = new a(null);
    }

    public static a zX() {
        return c.ant;
    }

    private a() {
        this.anm = null;
        this.ann = null;
        this.ano = null;
        this.anp = false;
        this.anp = false;
        this.ann = null;
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public int zY() {
        return com.baidu.tbadk.core.sharedPref.b.sO().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String zZ() {
        int zY = zY();
        if (zY >= 10) {
            com.baidu.tbadk.core.sharedPref.b.sO().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.sO().putString("KeyOfSharedPrefValidIp", "");
            this.anm = null;
            return null;
        }
        if (this.anm == null) {
            this.anm = com.baidu.tbadk.core.sharedPref.b.sO().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.j.isEmpty(this.anm)) {
            com.baidu.tbadk.core.sharedPref.b.sO().putInt("KeyOfSharedPrefImCount", zY + 1);
        } else {
            this.anm = null;
        }
        return this.anm;
    }

    public void eS(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.anm = str;
            com.baidu.tbadk.core.sharedPref.b.sO().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> Aa() {
        if (this.ann == null) {
            this.ann = eT(com.baidu.tbadk.core.sharedPref.b.sO().getString("KeyOfSharedPrefIpList", null));
        }
        return this.ann;
    }

    public void Ab() {
        this.anp = false;
    }

    public boolean Ac() {
        return this.anp;
    }

    public void a(InterfaceC0038a interfaceC0038a) {
        if (this.ano == null) {
            this.anp = true;
            this.ano = new b(interfaceC0038a);
            this.ano.setSelfExecute(true);
            this.ano.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> eT(String str) {
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
        private volatile ab afj = null;
        private InterfaceC0038a anq;

        public b(InterfaceC0038a interfaceC0038a) {
            this.anq = null;
            this.anq = interfaceC0038a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            int i = 0;
            try {
                this.afj = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
                String ta = this.afj.ta();
                if (this.afj.ty().uv().nU() && ta != null) {
                    JSONObject jSONObject = new JSONObject(ta);
                    if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.ann = a.this.eT(optString);
                        if (a.this.ann != null && a.this.ann.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < a.this.ann.size(); i2++) {
                                String str2 = (String) a.this.ann.get(i2);
                                h hVar = new h();
                                hVar.eW(str2);
                                if (hVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(hVar.Ap()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.ann = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new com.baidu.tbadk.coreExtra.websocketBase.b(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    a.this.ann.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.sO().putString("KeyOfSharedPrefIpList", str);
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
            a.this.ano = null;
            if (this.anq != null) {
                this.anq.Ad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r3) {
            a.this.ano = null;
            if (this.anq != null) {
                this.anq.Ad();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.ano = null;
            if (this.anq != null) {
                this.anq.Ad();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afj != null) {
                this.afj.dm();
                this.afj = null;
            }
            a.this.ano = null;
            super.cancel(true);
        }
    }
}
