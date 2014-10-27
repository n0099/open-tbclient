package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private ArrayList<k> ajZ = new ArrayList<>();
    private ArrayList<n> aka = new ArrayList<>();

    public ArrayList<n> yG() {
        return this.aka;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("banner");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    k kVar = new k();
                    kVar.parserJson(optJSONArray.getJSONObject(i));
                    this.ajZ.add(kVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("threadRecommend");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    n nVar = new n();
                    nVar.parserJson(optJSONArray2.getJSONObject(i2));
                    this.aka.add(nVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.aka.addAll(lVar.yG());
        }
    }
}
