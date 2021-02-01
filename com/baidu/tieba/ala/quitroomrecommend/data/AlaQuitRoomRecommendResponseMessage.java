package com.baidu.tieba.ala.quitroomrecommend.data;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaQuitRoomRecommendResponseMessage extends JsonHttpResponsedMessage {
    public List<a> igx;

    public AlaQuitRoomRecommendResponseMessage() {
        super(1021226);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("live")) != null) {
            this.igx = new ArrayList();
            a aVar = null;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (i2 % 2 == 0) {
                    aVar = new a();
                    this.igx.add(aVar);
                    AlaQuitRoomRecommendData alaQuitRoomRecommendData = new AlaQuitRoomRecommendData();
                    alaQuitRoomRecommendData.parserJson(optJSONObject);
                    aVar.igu = alaQuitRoomRecommendData;
                } else {
                    AlaQuitRoomRecommendData alaQuitRoomRecommendData2 = new AlaQuitRoomRecommendData();
                    alaQuitRoomRecommendData2.parserJson(optJSONObject);
                    aVar.igv = alaQuitRoomRecommendData2;
                }
            }
        }
    }
}
