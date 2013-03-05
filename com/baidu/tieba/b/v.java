package com.baidu.tieba.b;

import android.content.Context;
import com.baidu.tieba.a.al;
import com.baidu.tieba.a.ar;
import com.baidu.tieba.a.at;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private Context a;
    private ar b = new ar();
    private boolean c;
    private boolean d;

    public v(Context context, String str) {
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
            at atVar = new at();
            atVar.a(optJSONObject3);
            this.b.a(atVar);
            com.baidu.tieba.a.q qVar = new com.baidu.tieba.a.q();
            qVar.a(optJSONObject2);
            this.b.a(qVar);
            al alVar = new al();
            alVar.a(optJSONObject);
            alVar.a(this.a);
            this.b.a(alVar);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                al alVar2 = new al();
                alVar2.a(jSONObject2);
                alVar2.a(this.a);
                arrayList.add(alVar2);
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
            ag.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public ar a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean c() {
        return this.d;
    }

    public void b(boolean z) {
        this.d = z;
    }
}
