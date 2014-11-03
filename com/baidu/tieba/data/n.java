package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private boolean TP;
    private String akm;
    private String akn;
    private ArrayList<m> ako = new ArrayList<>();
    private String time;

    public String yK() {
        return this.akm;
    }

    public String getTime() {
        return this.time;
    }

    public ArrayList<m> yL() {
        return this.ako;
    }

    public boolean yM() {
        return this.TP;
    }

    public void bo(boolean z) {
        this.TP = z;
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.time = jSONObject.optString("publish_time");
            this.akm = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.TOTAL);
            this.akn = jSONObject.optString("update_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    m mVar = new m();
                    mVar.parserJson(optJSONArray.getJSONObject(i));
                    this.ako.add(mVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
