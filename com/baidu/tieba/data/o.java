package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private ArrayList<n> a = new ArrayList<>();
    private ArrayList<q> b = new ArrayList<>();

    public ArrayList<n> a() {
        return this.a;
    }

    public ArrayList<q> b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("banner");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    n nVar = new n();
                    nVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(nVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("threadRecommend");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    q qVar = new q();
                    qVar.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(qVar);
                }
            }
        } catch (JSONException e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(o oVar) {
        if (oVar != null) {
            this.b.addAll(oVar.b());
        }
    }
}
