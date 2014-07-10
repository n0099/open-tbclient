package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private ArrayList<k> a = new ArrayList<>();
    private ArrayList<n> b = new ArrayList<>();

    public ArrayList<n> a() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("banner");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    k kVar = new k();
                    kVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(kVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("threadRecommend");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    n nVar = new n();
                    nVar.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(nVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.b.addAll(lVar.a());
        }
    }
}
