package com.baidu.tieba.b;

import com.baidu.tieba.a.ae;
import com.baidu.tieba.a.ah;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private ae c = new ae();
    private ArrayList a = new ArrayList();
    private ah b = new ah();
    private boolean d = true;

    public boolean a() {
        return this.d;
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public ArrayList b() {
        return this.a;
    }

    public ah c() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            ag.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    com.baidu.tieba.a.p pVar = new com.baidu.tieba.a.p();
                    pVar.a(optJSONArray2.optJSONObject(i));
                    this.a.add(pVar);
                }
            }
            this.c.a(jSONObject.optJSONObject("message"));
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            this.d = false;
            ag.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
