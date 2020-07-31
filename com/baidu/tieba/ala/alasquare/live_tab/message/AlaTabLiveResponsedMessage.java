package com.baidu.tieba.ala.alasquare.live_tab.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alasquare.live_tab.b.a;
import com.baidu.tieba.ala.alasquare.live_tab.b.d;
import com.baidu.tieba.ala.alasquare.live_tab.b.g;
import com.baidu.tieba.ala.alasquare.live_tab.b.h;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaTabLiveResponsedMessage extends JsonHttpResponsedMessage {
    public a hotLiveInfo;
    public d officialRecommendLiveInfo;
    public g stageLiveInfo;
    public h superEntranceInfo;
    public j tabAllLiveInfo;

    public AlaTabLiveResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("goldspace");
            if (optJSONObject2 != null) {
                this.superEntranceInfo = new h();
                this.superEntranceInfo.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("stage_live");
            if (optJSONObject3 != null) {
                this.stageLiveInfo = new g();
                this.stageLiveInfo.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("hot_live");
            if (optJSONObject4 != null) {
                this.hotLiveInfo = new a();
                this.hotLiveInfo.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("official_recommend");
            if (optJSONObject5 != null) {
                this.officialRecommendLiveInfo = new d();
                this.officialRecommendLiveInfo.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("all_lives");
            if (optJSONObject6 != null) {
                this.tabAllLiveInfo = new j();
                this.tabAllLiveInfo.parserJson(optJSONObject6);
            }
        }
    }
}
