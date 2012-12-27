package com.baidu.tieba.b;

import android.content.Context;
import com.baidu.tieba.a.am;
import com.baidu.tieba.a.aq;
import com.baidu.tieba.a.as;
import com.baidu.tieba.c.ae;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private Context a;
    private aq b = new aq();
    private boolean c;
    private boolean d;

    public r(Context context, String str) {
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
            as asVar = new as();
            asVar.a(optJSONObject3);
            this.b.a(asVar);
            com.baidu.tieba.a.p pVar = new com.baidu.tieba.a.p();
            pVar.a(optJSONObject2);
            this.b.a(pVar);
            am amVar = new am();
            amVar.a(optJSONObject);
            amVar.a(this.a);
            this.b.a(amVar);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                am amVar2 = new am();
                amVar2.a(jSONObject2);
                amVar2.a(this.a);
                arrayList.add(amVar2);
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
            ae.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public aq a() {
        return this.b;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }
}
