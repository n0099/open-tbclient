package com.baidu.tieba.ala.alasquare.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.data.AlaSquareTabData;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveSquareGetTabResponse extends JsonHttpResponsedMessage {
    public AlaSquareTabData mTabData;

    public AlaLiveSquareGetTabResponse(int i2) {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_SQUARE_GET_TAB_INFO);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        AlaSquareTabData alaSquareTabData = new AlaSquareTabData();
        this.mTabData = alaSquareTabData;
        alaSquareTabData.hasSearch = optJSONObject.optInt("has_search");
        this.mTabData.showNum = optJSONObject.optInt("show_num");
        ArrayList arrayList = null;
        JSONArray optJSONArray = optJSONObject.optJSONArray("entry");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            ArrayList arrayList2 = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                AlaSquareTabInfo alaSquareTabInfo = new AlaSquareTabInfo();
                alaSquareTabInfo.parse(optJSONArray.optJSONObject(i3));
                arrayList2.add(alaSquareTabInfo);
            }
            arrayList = arrayList2;
        }
        this.mTabData.tabInfoList = arrayList;
    }

    public AlaSquareTabData getTabData() {
        return this.mTabData;
    }
}
