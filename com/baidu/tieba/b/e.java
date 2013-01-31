package com.baidu.tieba.b;

import com.baidu.tieba.a.ak;
import com.baidu.tieba.a.av;
import com.baidu.tieba.c.af;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private ArrayList a = new ArrayList();
    private ak b = new ak();

    public ArrayList a() {
        return this.a;
    }

    public ak b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            af.b("FrsModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    av avVar = new av();
                    avVar.a(optJSONArray.optJSONObject(i));
                    avVar.p();
                    this.a.add(avVar);
                }
            }
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            af.b("GuessListModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
