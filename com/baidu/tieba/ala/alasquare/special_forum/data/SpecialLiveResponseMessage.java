package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.i0.t.d.f.c.a;
import d.b.i0.t.d.f.c.h;
import d.b.i0.t.d.f.c.i;
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
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mData = new h();
        jSONObject.optInt("concern_live_show");
        JSONObject optJSONObject = jSONObject.optJSONObject("head_live");
        if (optJSONObject != null) {
            a aVar = new a();
            aVar.a(optJSONObject);
            this.mData.f62111a = aVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("tab_info");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                if (jSONObject2 != null) {
                    SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
                    specialLiveTabInfo.a(jSONObject2);
                    arrayList.add(specialLiveTabInfo);
                }
            }
            this.mData.f62112b = arrayList;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_info");
        if (optJSONObject2 != null) {
            AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
            alaUserInfoData.parserJson(optJSONObject2);
            this.mData.f62114d = alaUserInfoData;
        }
        this.mData.f62113c = jSONObject.optInt("is_like") == 1;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("user_sign_info");
        if (optJSONObject2 != null) {
            i iVar = new i();
            iVar.a(optJSONObject3);
            this.mData.f62115e = iVar;
        }
    }

    public h getData() {
        return this.mData;
    }
}
