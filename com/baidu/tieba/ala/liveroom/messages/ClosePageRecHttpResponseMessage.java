package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ClosePageRecHttpResponseMessage extends JsonHttpResponsedMessage {
    public ArrayList<AlaLiveInfoData> glA;

    public ClosePageRecHttpResponseMessage() {
        super(1021207);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        this.glA = new ArrayList<>();
        if (getError() == 0 && (optJSONArray = jSONObject.optJSONArray("live")) != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                    alaLiveInfoData.parserJson(optJSONObject);
                    this.glA.add(alaLiveInfoData);
                }
            }
        }
    }
}
