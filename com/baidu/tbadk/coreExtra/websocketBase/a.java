package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aVF;
    private List<String> aVG;
    private b aVH;
    private boolean aVI;

    /* renamed from: com.baidu.tbadk.coreExtra.websocketBase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0166a {
        void KY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a aVM = new a();
    }

    public static a KT() {
        return c.aVM;
    }

    private a() {
        this.aVF = null;
        this.aVG = null;
        this.aVH = null;
        this.aVI = false;
        this.aVI = false;
        this.aVG = null;
    }

    public int KU() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String KV() {
        int KU = KU();
        if (KU >= 10) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", "");
            this.aVF = null;
            return null;
        }
        if (this.aVF == null) {
            this.aVF = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.aVF)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KeyOfSharedPrefImCount", KU + 1);
        } else {
            this.aVF = null;
        }
        return this.aVF;
    }

    public void hl(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.aVF = str;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.aVG == null) {
            this.aVG = hm(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("KeyOfSharedPrefIpList", null));
        }
        return this.aVG;
    }

    public void KW() {
        this.aVI = false;
    }

    public boolean KX() {
        return this.aVI;
    }

    public void a(InterfaceC0166a interfaceC0166a) {
        if (this.aVH == null) {
            this.aVI = true;
            this.aVH = new b(interfaceC0166a);
            this.aVH.setSelfExecute(true);
            this.aVH.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> hm(String str) {
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
        private InterfaceC0166a aVJ;
        private volatile x mNetwork = null;

        public b(InterfaceC0166a interfaceC0166a) {
            this.aVJ = null;
            this.aVJ = interfaceC0166a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String CL = this.mNetwork.CL();
                if (this.mNetwork.Dj().Ei().isRequestSuccess() && CL != null) {
                    JSONObject jSONObject = new JSONObject(CL);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.aVG = a.this.hm(optString);
                        if (a.this.aVG != null && a.this.aVG.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.aVG.size(); i++) {
                                String str2 = (String) a.this.aVG.get(i);
                                e eVar = new e();
                                eVar.hp(str2);
                                if (eVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(eVar.Lj()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.aVG = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.websocketBase.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    /* renamed from: b */
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.g.b.l(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.b.l(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.aVG.add(entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("KeyOfSharedPrefIpList", str);
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
            a.this.aVH = null;
            if (this.aVJ != null) {
                this.aVJ.KY();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.aVH = null;
            if (this.aVJ != null) {
                this.aVJ.KY();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.aVH = null;
            if (this.aVJ != null) {
                this.aVJ.KY();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
                this.mNetwork = null;
            }
            a.this.aVH = null;
            super.cancel(true);
        }
    }
}
