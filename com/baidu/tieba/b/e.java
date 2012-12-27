package com.baidu.tieba.b;

import com.baidu.tieba.a.aj;
import com.baidu.tieba.a.as;
import com.baidu.tieba.c.ae;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private ArrayList a = new ArrayList();
    private aj b = new aj();

    public ArrayList a() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ae.b("FrsModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    as asVar = new as();
                    asVar.a(optJSONArray.optJSONObject(i));
                    asVar.p();
                    this.a.add(asVar);
                }
            }
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            ae.b("GuessListModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public aj b() {
        return this.b;
    }
}
