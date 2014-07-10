package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private ArrayList<m> e = new ArrayList<>();

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public ArrayList<m> c() {
        return this.e;
    }

    public boolean d() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optString("publish_time");
            this.a = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.TOTAL);
            this.c = jSONObject.optString("update_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    m mVar = new m();
                    mVar.a(optJSONArray.getJSONObject(i));
                    this.e.add(mVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
