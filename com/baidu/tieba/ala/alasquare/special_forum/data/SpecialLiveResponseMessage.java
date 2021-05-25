package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.v.d.f.c.a;
import d.a.n0.v.d.f.c.h;
import d.a.n0.v.d.f.c.i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SpecialLiveResponseMessage extends JsonHttpResponsedMessage {
    public h mData;

    public SpecialLiveResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mData = new h();
        jSONObject.optInt("concern_live_show");
        JSONObject optJSONObject = jSONObject.optJSONObject("head_live");
        if (optJSONObject != null) {
            a aVar = new a();
            aVar.a(optJSONObject);
            this.mData.f61732a = aVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("tab_info");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
                if (jSONObject2 != null) {
                    SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
                    specialLiveTabInfo.a(jSONObject2);
                    arrayList.add(specialLiveTabInfo);
                }
            }
            this.mData.f61733b = arrayList;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_info");
        if (optJSONObject2 != null) {
            AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
            alaUserInfoData.parserJson(optJSONObject2);
            this.mData.f61735d = alaUserInfoData;
        }
        this.mData.f61734c = jSONObject.optInt("is_like") == 1;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("user_sign_info");
        if (optJSONObject2 != null) {
            i iVar = new i();
            iVar.a(optJSONObject3);
            this.mData.f61736e = iVar;
        }
    }

    public h getData() {
        return this.mData;
    }
}
