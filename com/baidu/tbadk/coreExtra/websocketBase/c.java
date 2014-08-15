package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Object, Integer, Void> {
    final /* synthetic */ a a;
    private b b;
    private volatile ae c = null;

    public c(a aVar, b bVar) {
        this.a = aVar;
        this.b = null;
        this.b = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect condition in loop: B:14:0x007a */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void doInBackground(Object... objArr) {
        List b;
        List list;
        List list2;
        List list3;
        String str;
        List list4;
        List list5;
        int i = 0;
        try {
            this.c = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_IP_LIST);
            String h = this.c.h();
            if (this.c.a().b().b() && h != null) {
                JSONObject jSONObject = new JSONObject(h);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a aVar = this.a;
                    b = this.a.b(optString);
                    aVar.b = b;
                    list = this.a.b;
                    if (list != null) {
                        list2 = this.a.b;
                        if (list2.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i2 = 0; i2 < list3.size(); i2++) {
                                list5 = this.a.b;
                                String str2 = (String) list5.get(i2);
                                p pVar = new p();
                                pVar.a(str2);
                                if (pVar.a()) {
                                    hashMap.put(str2, Integer.valueOf(pVar.b()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                this.a.b = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new d(this));
                                StringBuilder sb = new StringBuilder(50);
                                for (Map.Entry entry : arrayList) {
                                    list4 = this.a.b;
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
                            com.baidu.tbadk.core.sharedPref.b.a().b("KeyOfSharedPrefIpList", str);
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
    /* renamed from: a */
    public void onPostExecute(Void r3) {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onCancelled(Void r3) {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        this.a.c = null;
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.f();
            this.c = null;
        }
        this.a.c = null;
        super.cancel(true);
    }
}
