package com.baidu.tieba.b;

import com.baidu.tieba.a.aj;
import com.baidu.tieba.c.ae;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private ArrayList a = new ArrayList();
    private aj b = new aj();
    private Date c = null;
    private boolean d = true;

    public ArrayList a() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            ae.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.a.p pVar = new com.baidu.tieba.a.p();
                    pVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(pVar);
                }
            }
            this.b.a(jSONObject.optJSONObject("page"));
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.c = new Date(optLong);
            } else {
                this.c = new Date();
            }
        } catch (Exception e) {
            this.d = false;
            ae.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
