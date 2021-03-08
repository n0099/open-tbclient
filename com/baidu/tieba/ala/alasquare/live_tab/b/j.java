package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class j {
    public ArrayList<SdkLiveInfoData> gCF;
    public boolean hasMore = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hasMore = jSONObject.optInt("has_more") == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("live_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.gCF = new ArrayList<>(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
                        sdkLiveInfoData.fromJson(optJSONObject);
                        this.gCF.add(sdkLiveInfoData);
                    }
                }
            }
        }
    }
}
