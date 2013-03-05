package com.baidu.tieba.b;

import com.baidu.tieba.a.ah;
import com.baidu.tieba.a.at;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private ArrayList a = new ArrayList();
    private ah b = new ah();

    public ArrayList a() {
        return this.a;
    }

    public ah b() {
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
                    at atVar = new at();
                    atVar.a(optJSONArray.optJSONObject(i));
                    atVar.p();
                    this.a.add(atVar);
                }
            }
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            ag.b("GuessListModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
