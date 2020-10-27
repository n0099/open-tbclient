package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SpecialLiveResponseMessage extends JsonHttpResponsedMessage {
    private h mData;

    public SpecialLiveResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.mData = new h();
            this.mData.gkc = jSONObject.optInt("concern_live_show") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("head_live");
            if (optJSONObject != null) {
                a aVar = new a();
                aVar.parse(optJSONObject);
                this.mData.gkb = aVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("tab_info");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                    if (jSONObject2 != null) {
                        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
                        specialLiveTabInfo.parse(jSONObject2);
                        arrayList.add(specialLiveTabInfo);
                    }
                }
                this.mData.tabInfoList = arrayList;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
                alaUserInfoData.parserJson(optJSONObject2);
                this.mData.gke = alaUserInfoData;
            }
            this.mData.gkd = jSONObject.optInt("is_like") == 1;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user_sign_info");
            if (optJSONObject2 != null) {
                i iVar = new i();
                iVar.parserJson(optJSONObject3);
                this.mData.gkf = iVar;
            }
        }
    }

    public h getData() {
        return this.mData;
    }
}
