package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private boolean TL;
    private String akd;
    private String ake;
    private ArrayList<m> akf = new ArrayList<>();
    private String time;

    public String yI() {
        return this.akd;
    }

    public String getTime() {
        return this.time;
    }

    public ArrayList<m> yJ() {
        return this.akf;
    }

    public boolean yK() {
        return this.TL;
    }

    public void bo(boolean z) {
        this.TL = z;
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.time = jSONObject.optString("publish_time");
            this.akd = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.TOTAL);
            this.ake = jSONObject.optString("update_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    m mVar = new m();
                    mVar.parserJson(optJSONArray.getJSONObject(i));
                    this.akf.add(mVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
