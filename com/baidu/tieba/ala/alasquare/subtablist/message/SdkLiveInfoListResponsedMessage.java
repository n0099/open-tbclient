package com.baidu.tieba.ala.alasquare.subtablist.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SdkLiveInfoListResponsedMessage extends JsonHttpResponsedMessage {
    private List<SdkLiveInfoData> dataList;
    private boolean hasMore;

    public SdkLiveInfoListResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        this.hasMore = false;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hasMore = optJSONObject.optInt("has_more") == 1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("live_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.dataList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
                        sdkLiveInfoData.fromJson(optJSONObject2);
                        this.dataList.add(sdkLiveInfoData);
                    }
                }
            }
        }
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<SdkLiveInfoData> getLiveList() {
        return this.dataList;
    }
}
