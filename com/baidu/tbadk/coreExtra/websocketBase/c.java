package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Object, Integer, Void> {
    private volatile aa aaG = null;
    private b agW;
    final /* synthetic */ a agX;

    public c(a aVar, b bVar) {
        this.agX = aVar;
        this.agW = null;
        this.agW = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect condition in loop: B:14:0x0077 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void doInBackground(Object... objArr) {
        List ek;
        List list;
        List list2;
        List list3;
        String str;
        List list4;
        List list5;
        int i = 0;
        try {
            this.aaG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
            String sw = this.aaG.sw();
            if (this.aaG.sX().tT().qa() && sw != null) {
                JSONObject jSONObject = new JSONObject(sw);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a aVar = this.agX;
                    ek = this.agX.ek(optString);
                    aVar.agT = ek;
                    list = this.agX.agT;
                    if (list != null) {
                        list2 = this.agX.agT;
                        if (list2.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < list3.size(); i2++) {
                                list5 = this.agX.agT;
                                String str2 = (String) list5.get(i2);
                                p pVar = new p();
                                pVar.en(str2);
                                if (pVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(pVar.yw()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                this.agX.agT = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new d(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    list4 = this.agX.agT;
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
                            com.baidu.tbadk.core.sharedPref.b.sl().putString("KeyOfSharedPrefIpList", str);
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
        this.agX.agU = null;
        if (this.agW != null) {
            this.agW.yl();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onCancelled(Void r3) {
        this.agX.agU = null;
        if (this.agW != null) {
            this.agW.yl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        this.agX.agU = null;
        if (this.agW != null) {
            this.agW.yl();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.aaG != null) {
            this.aaG.gS();
            this.aaG = null;
        }
        this.agX.agU = null;
        super.cancel(true);
    }
}
