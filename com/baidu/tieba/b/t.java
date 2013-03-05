package com.baidu.tieba.b;

import com.baidu.tieba.a.ah;
import com.baidu.tieba.a.aj;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.a.d {
    private ArrayList a = new ArrayList();
    private ah b = new ah();

    public ArrayList a() {
        return this.a;
    }

    public ah b() {
        return this.b;
    }

    @Override // com.baidu.tieba.a.d
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                aj ajVar = new aj();
                ajVar.a(optJSONArray.optJSONObject(i));
                this.a.add(ajVar);
            }
        }
        this.b.a(jSONObject.optJSONObject("page"));
    }
}
