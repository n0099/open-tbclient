package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private ArrayList<j> a = new ArrayList<>();
    private ArrayList<m> b = new ArrayList<>();

    public ArrayList<m> a() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("banner");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    j jVar = new j();
                    jVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(jVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("threadRecommend");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    m mVar = new m();
                    mVar.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(mVar);
                }
            }
        } catch (JSONException e) {
            BdLog.e(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(k kVar) {
        if (kVar != null) {
            this.b.addAll(kVar.a());
        }
    }
}
