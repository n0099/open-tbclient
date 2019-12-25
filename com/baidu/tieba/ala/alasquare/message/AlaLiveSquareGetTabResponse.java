package com.baidu.tieba.ala.alasquare.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.data.AlaSquareTabData;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLiveSquareGetTabResponse extends JsonHttpResponsedMessage {
    private AlaSquareTabData mTabData;

    public AlaLiveSquareGetTabResponse(int i) {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_SQUARE_GET_TAB_INFO);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.mTabData = new AlaSquareTabData();
            this.mTabData.hasSearch = optJSONObject.optInt("has_search");
            this.mTabData.showNum = optJSONObject.optInt("show_num");
            ArrayList arrayList = null;
            JSONArray optJSONArray = optJSONObject.optJSONArray("entry");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    AlaSquareTabInfo alaSquareTabInfo = new AlaSquareTabInfo();
                    alaSquareTabInfo.parse(optJSONArray.optJSONObject(i2));
                    arrayList.add(alaSquareTabInfo);
                }
            }
            this.mTabData.tabInfoList = arrayList;
        }
    }

    public AlaSquareTabData getTabData() {
        return this.mTabData;
    }
}
