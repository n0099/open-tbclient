package com.baidu.tieba.c;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bm {
    private Context a;
    private com.baidu.tieba.a.ax b = new com.baidu.tieba.a.ax();

    public bm(Context context, String str) {
        this.a = context;
        a(str);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("post");
            JSONArray optJSONArray = jSONObject.optJSONArray("subpost_list");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("thread");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("anti");
            com.baidu.tieba.a.b bVar = new com.baidu.tieba.a.b();
            bVar.a(optJSONObject4);
            this.b.a(bVar);
            com.baidu.tieba.a.bb bbVar = new com.baidu.tieba.a.bb();
            bbVar.a(optJSONObject3);
            this.b.a(bbVar);
            com.baidu.tieba.a.s sVar = new com.baidu.tieba.a.s();
            sVar.a(optJSONObject2);
            this.b.a(sVar);
            com.baidu.tieba.a.aq aqVar = new com.baidu.tieba.a.aq();
            aqVar.a(optJSONObject);
            aqVar.c(this.a);
            this.b.a(aqVar);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                com.baidu.tieba.a.aq aqVar2 = new com.baidu.tieba.a.aq();
                aqVar2.a(jSONObject2);
                aqVar2.c(this.a);
                arrayList.add(aqVar2);
            }
            this.b.a(arrayList);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("page");
            int optInt = optJSONObject5.optInt("total_page");
            int optInt2 = optJSONObject5.optInt("page_size");
            int optInt3 = optJSONObject5.optInt("current_page");
            int optInt4 = optJSONObject5.optInt("total_count");
            this.b.d(optInt3);
            this.b.c(optInt2);
            this.b.b(optInt4);
            this.b.a(optInt);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public com.baidu.tieba.a.ax a() {
        return this.b;
    }
}
