package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaUserLiveMarkInfoResponseMessage extends JsonHttpResponsedMessage {
    private List<AlaLiveMarkData> ekA;

    public AlaUserLiveMarkInfoResponseMessage() {
        super(1021121);
        this.ekA = new ArrayList();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.parserJson(optJSONObject);
                this.ekA.add(alaLiveMarkData);
            }
        }
    }

    public List<AlaLiveMarkData> aUF() {
        return this.ekA;
    }
}
