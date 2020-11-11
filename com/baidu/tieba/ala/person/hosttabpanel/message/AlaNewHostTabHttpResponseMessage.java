package com.baidu.tieba.ala.person.hosttabpanel.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaNewHostTabHttpResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveUserInfoData aIV;
    private AlaLiveUserInfoData aJr;
    private List<AlaLiveInfoData> hAA;
    private boolean mHasMore;
    private AlaLocationData mLocationData;
    private AlaRelationData mRelationData;

    public AlaNewHostTabHttpResponseMessage() {
        super(1021076);
        this.hAA = new ArrayList();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("live_user_info");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    if (this.aIV == null) {
                        this.aIV = new AlaLiveUserInfoData();
                    }
                    this.aIV.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("relation_info");
                if (optJSONObject4 != null) {
                    if (this.mRelationData == null) {
                        this.mRelationData = new AlaRelationData();
                    }
                    this.mRelationData.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject("location_info");
                if (optJSONObject5 != null) {
                    if (this.mLocationData == null) {
                        this.mLocationData = new AlaLocationData();
                    }
                    this.mLocationData.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("login_user_info");
                if (optJSONObject6 != null) {
                    if (this.aJr == null) {
                        this.aJr = new AlaLiveUserInfoData();
                    }
                    this.aJr.parserJson(optJSONObject6);
                }
            }
            ListUtils.clear(this.hAA);
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("live_record_info");
            if (optJSONObject7 != null) {
                JSONArray optJSONArray = optJSONObject7.optJSONArray("record_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        if (jSONObject2 != null) {
                            AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                            alaLiveInfoData.parserJson(jSONObject2);
                            this.hAA.add(alaLiveInfoData);
                        }
                    }
                }
                JSONObject optJSONObject8 = optJSONObject7.optJSONObject("page");
                if (optJSONObject8 != null) {
                    this.mHasMore = optJSONObject8.optInt("has_more") == 1;
                }
            }
        }
    }
}
