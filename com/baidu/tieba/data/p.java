package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class p {
    private ArrayList<o> a = new ArrayList<>();
    private ArrayList<r> b = new ArrayList<>();

    public final ArrayList<o> a() {
        return this.a;
    }

    public final ArrayList<r> b() {
        return this.b;
    }

    public final void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("banner");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    o oVar = new o();
                    oVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(oVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("threadRecommend");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    r rVar = new r();
                    rVar.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(rVar);
                }
            }
        } catch (JSONException e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public final void a(p pVar) {
        if (pVar != null) {
            this.b.addAll(pVar.b);
        }
    }
}
