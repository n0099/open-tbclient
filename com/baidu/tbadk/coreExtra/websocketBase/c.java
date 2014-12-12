package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Object, Integer, Void> {
    private volatile ad CV = null;
    private b Vf;
    final /* synthetic */ a Vg;

    public c(a aVar, b bVar) {
        this.Vg = aVar;
        this.Vf = null;
        this.Vf = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect condition in loop: B:14:0x0077 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void doInBackground(Object... objArr) {
        List dL;
        List list;
        List list2;
        List list3;
        String str;
        List list4;
        List list5;
        int i = 0;
        try {
            this.CV = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
            String ov = this.CV.ov();
            if (this.CV.oW().pW().ma() && ov != null) {
                JSONObject jSONObject = new JSONObject(ov);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a aVar = this.Vg;
                    dL = this.Vg.dL(optString);
                    aVar.Vc = dL;
                    list = this.Vg.Vc;
                    if (list != null) {
                        list2 = this.Vg.Vc;
                        if (list2.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < list3.size(); i2++) {
                                list5 = this.Vg.Vc;
                                String str2 = (String) list5.get(i2);
                                p pVar = new p();
                                pVar.dO(str2);
                                if (pVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(pVar.ua()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                this.Vg.Vc = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new d(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    list4 = this.Vg.Vc;
                                    list4.add((String) entry.getKey());
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
                            com.baidu.tbadk.core.sharedPref.b.og().putString("KeyOfSharedPrefIpList", str);
                            return null;
                        }
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
        this.Vg.Vd = null;
        if (this.Vf != null) {
            this.Vf.tP();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onCancelled(Void r3) {
        this.Vg.Vd = null;
        if (this.Vf != null) {
            this.Vf.tP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        this.Vg.Vd = null;
        if (this.Vf != null) {
            this.Vf.tP();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.CV != null) {
            this.CV.dL();
            this.CV = null;
        }
        this.Vg.Vd = null;
        super.cancel(true);
    }
}
