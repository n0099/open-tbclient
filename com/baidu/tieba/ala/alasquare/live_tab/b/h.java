package com.baidu.tieba.ala.alasquare.live_tab.b;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public boolean ePS = false;
    public ArrayList<a> ePT;
    public String ePU;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_follow");
            if (optJSONObject != null) {
                this.ePS = optJSONObject.optInt("has_follow_live") == 1;
                JSONArray optJSONArray = optJSONObject.optJSONArray("follow_live_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.ePT = new ArrayList<>(optJSONArray.length());
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            a aVar = new a();
                            aVar.parserJson(optJSONObject2);
                            this.ePT.add(aVar);
                        }
                    }
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("live_rank");
            if (optJSONObject3 != null) {
                this.ePU = optJSONObject3.optString("url");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public String portrait;
        public String userId;

        public a() {
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.userId = jSONObject.optString("user_id");
                this.portrait = jSONObject.optString("portrait");
            }
        }
    }
}
