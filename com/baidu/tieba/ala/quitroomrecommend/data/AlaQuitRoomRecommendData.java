package com.baidu.tieba.ala.quitroomrecommend.data;

import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaQuitRoomRecommendData extends AlaLiveInfoData {
    public String distance;
    public String labelIcon;
    public String labelText;

    @Override // com.baidu.live.data.AlaLiveInfoData
    public void parserJson(JSONObject jSONObject) {
        super.parserJson(jSONObject);
        if (jSONObject != null) {
            this.distance = jSONObject.optString("distance");
            this.labelIcon = jSONObject.optString("cover_tag_pic");
            this.labelText = jSONObject.optString("cover_tag_text");
        }
    }
}
