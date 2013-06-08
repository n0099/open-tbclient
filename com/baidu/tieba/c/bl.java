package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bl extends com.baidu.tieba.a.d {
    private ArrayList a = new ArrayList();
    private com.baidu.tieba.a.al b = new com.baidu.tieba.a.al();

    public ArrayList a() {
        return this.a;
    }

    public com.baidu.tieba.a.al b() {
        return this.b;
    }

    @Override // com.baidu.tieba.a.d
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                com.baidu.tieba.a.ap apVar = new com.baidu.tieba.a.ap();
                apVar.a(optJSONArray.optJSONObject(i));
                this.a.add(apVar);
            }
        }
        this.b.a(jSONObject.optJSONObject("page"));
    }
}
