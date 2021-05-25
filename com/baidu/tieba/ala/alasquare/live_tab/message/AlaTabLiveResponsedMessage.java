package com.baidu.tieba.ala.alasquare.live_tab.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.c.e.p.k;
import d.a.n0.v.d.c.e.a;
import d.a.n0.v.d.c.e.d;
import d.a.n0.v.d.c.e.g;
import d.a.n0.v.d.c.e.h;
import d.a.n0.v.d.c.e.j;
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
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("goldspace");
        if (optJSONObject2 != null) {
            h hVar = new h();
            this.superEntranceInfo = hVar;
            hVar.a(optJSONObject2);
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("stage_live");
        if (optJSONObject3 != null) {
            g gVar = new g();
            this.stageLiveInfo = gVar;
            gVar.b(optJSONObject3);
        }
        JSONObject optJSONObject4 = optJSONObject.optJSONObject("hot_live");
        if (optJSONObject4 != null) {
            a aVar = new a();
            this.hotLiveInfo = aVar;
            aVar.a(optJSONObject4);
        }
        JSONObject optJSONObject5 = optJSONObject.optJSONObject("official_recommend");
        if (optJSONObject5 != null) {
            d dVar = new d();
            this.officialRecommendLiveInfo = dVar;
            dVar.a(optJSONObject5);
        }
        JSONObject optJSONObject6 = optJSONObject.optJSONObject("all_lives");
        if (optJSONObject6 != null) {
            j jVar = new j();
            this.tabAllLiveInfo = jVar;
            jVar.a(optJSONObject6);
        }
        String optString = optJSONObject.optString("show_switch", null);
        if (k.isEmpty(optString)) {
            return;
        }
        TbSingleton.getInstance().setYyCloudSwitch(optString);
    }
}
