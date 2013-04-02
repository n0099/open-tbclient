package com.baidu.tieba.b;

import com.baidu.tieba.a.aj;
import com.baidu.tieba.a.al;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.a.d {
    private ArrayList a = new ArrayList();
    private aj b = new aj();

    public ArrayList a() {
        return this.a;
    }

    public aj b() {
        return this.b;
    }

    @Override // com.baidu.tieba.a.d
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                al alVar = new al();
                alVar.a(optJSONArray.optJSONObject(i));
                this.a.add(alVar);
            }
        }
        this.b.a(jSONObject.optJSONObject("page"));
    }
}
