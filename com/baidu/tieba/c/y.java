package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private com.baidu.tieba.a.s a = new com.baidu.tieba.a.s();
    private ArrayList b = new ArrayList();
    private ArrayList c = new ArrayList();
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private com.baidu.tieba.a.b g = new com.baidu.tieba.a.b();
    private com.baidu.tieba.a.ak h = new com.baidu.tieba.a.ak();

    public ArrayList a() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a.a(jSONObject.optJSONObject("forum"));
                this.h.a(jSONObject.optJSONObject("user"));
                this.g.a(jSONObject.optJSONObject("anti"));
                JSONObject optJSONObject = jSONObject.optJSONObject("photo_data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("thread_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            com.baidu.tieba.a.bd bdVar = new com.baidu.tieba.a.bd();
                            bdVar.a(optJSONArray.optJSONObject(i));
                            this.b.add(bdVar);
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("alb_id_list");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            this.c.add(optJSONArray2.optString(i2));
                        }
                    }
                    this.d = optJSONObject.optInt("has_more", 0);
                    this.e = optJSONObject.optInt("amount", 0);
                    this.f = optJSONObject.optInt("current_count", 0);
                }
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
