package com.baidu.tieba.b;

import com.baidu.tieba.a.aj;
import com.baidu.tieba.a.ax;
import com.baidu.tieba.c.ag;
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

    public aj b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ag.b("FrsModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ax axVar = new ax();
                    axVar.a(optJSONArray.optJSONObject(i));
                    axVar.r();
                    this.a.add(axVar);
                }
            }
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            ag.b("GuessListModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
