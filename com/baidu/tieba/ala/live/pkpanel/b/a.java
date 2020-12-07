package com.baidu.tieba.ala.live.pkpanel.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String activityName;
    public List<b> gGo;
    public String hba;
    public String mTitle;

    public void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mTitle = jSONObject.optString("title");
            this.activityName = jSONObject.optString("mainTitle");
            this.hba = jSONObject.optString("content");
            JSONArray optJSONArray = jSONObject.optJSONArray("gifts");
            if (optJSONArray != null) {
                this.gGo = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    b bVar = new b();
                    bVar.icon = optJSONObject.optString("giftUrl");
                    bVar.name = optJSONObject.optString("giftName");
                    bVar.type = optJSONObject.optString("type");
                    bVar.hbb = optJSONObject.optString("color");
                    bVar.content = optJSONObject.optString("description");
                    this.gGo.add(bVar);
                }
            }
        }
    }
}
