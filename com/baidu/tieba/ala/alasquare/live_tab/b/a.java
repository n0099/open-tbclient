package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public ArrayList<SdkLiveInfoData> grG;

    public void parserJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("live_list")) != null && optJSONArray.length() > 0) {
            this.grG = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
                    sdkLiveInfoData.fromJson(optJSONObject);
                    this.grG.add(sdkLiveInfoData);
                }
            }
        }
    }
}
