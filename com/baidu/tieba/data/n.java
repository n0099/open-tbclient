package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1021a = new ArrayList();
    private ArrayList b = new ArrayList();

    public ArrayList a() {
        return this.f1021a;
    }

    public ArrayList b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("banner");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    m mVar = new m();
                    mVar.a(optJSONArray.getJSONObject(i));
                    this.f1021a.add(mVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("threadRecommend");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    p pVar = new p();
                    pVar.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(pVar);
                }
            }
        } catch (JSONException e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(n nVar) {
        if (nVar != null) {
            this.b.addAll(nVar.b());
        }
    }
}
