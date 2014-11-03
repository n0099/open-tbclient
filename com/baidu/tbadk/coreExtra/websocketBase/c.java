package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Object, Integer, Void> {
    private b Pt;
    final /* synthetic */ a Pu;
    private volatile ac yV = null;

    public c(a aVar, b bVar) {
        this.Pu = aVar;
        this.Pt = null;
        this.Pt = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect condition in loop: B:14:0x0077 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void doInBackground(Object... objArr) {
        List cP;
        List list;
        List list2;
        List list3;
        String str;
        List list4;
        List list5;
        int i = 0;
        try {
            this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
            String lA = this.yV.lA();
            if (this.yV.mc().nb().jq() && lA != null) {
                JSONObject jSONObject = new JSONObject(lA);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a aVar = this.Pu;
                    cP = this.Pu.cP(optString);
                    aVar.Pq = cP;
                    list = this.Pu.Pq;
                    if (list != null) {
                        list2 = this.Pu.Pq;
                        if (list2.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < list3.size(); i2++) {
                                list5 = this.Pu.Pq;
                                String str2 = (String) list5.get(i2);
                                p pVar = new p();
                                pVar.cS(str2);
                                if (pVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(pVar.qH()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                this.Pu.Pq = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new d(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    list4 = this.Pu.Pq;
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
                            com.baidu.tbadk.core.sharedPref.b.lk().putString("KeyOfSharedPrefIpList", str);
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
    public void onPostExecute(Void r3) {
        this.Pu.Pr = null;
        if (this.Pt != null) {
            this.Pt.qw();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onCancelled(Void r3) {
        this.Pu.Pr = null;
        if (this.Pt != null) {
            this.Pt.qw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        this.Pu.Pr = null;
        if (this.Pt != null) {
            this.Pt.qw();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        this.Pu.Pr = null;
        super.cancel(true);
    }
}
