package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bi extends com.baidu.tieba.a.d {
    private ArrayList a = new ArrayList();
    private com.baidu.tieba.a.ak b = new com.baidu.tieba.a.ak();

    public ArrayList a() {
        return this.a;
    }

    public com.baidu.tieba.a.ak b() {
        return this.b;
    }

    @Override // com.baidu.tieba.a.d
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                com.baidu.tieba.a.ao aoVar = new com.baidu.tieba.a.ao();
                aoVar.a(optJSONArray.optJSONObject(i));
                this.a.add(aoVar);
            }
        }
        this.b.a(jSONObject.optJSONObject("page"));
    }
}
