package com.baidu.tieba.ala.liveroom.recommend.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public List<AlaRecommendLiveData> list;
    public int total_count;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        this.total_count = jSONObject.optInt("total_count");
        this.list = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    AlaRecommendLiveData alaRecommendLiveData = new AlaRecommendLiveData();
                    alaRecommendLiveData.type = this.type;
                    alaRecommendLiveData.parserJson(optJSONObject);
                    this.list.add(alaRecommendLiveData);
                }
            }
        }
    }
}
