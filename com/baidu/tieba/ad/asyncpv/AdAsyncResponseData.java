package com.baidu.tieba.ad.asyncpv;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdAsyncResponseData extends JsonHttpResponsedMessage {
    public List<AdvertAppInfo> mAds;

    public AdAsyncResponseData() {
        super(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST);
    }

    private List<AdvertAppInfo> parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
        if (optJSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2).optJSONObject("adInfo");
            if (optJSONObject2 != null) {
                arrayList.add(AdvertAppInfo.L4(optJSONObject2));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mAds = parseJson(jSONObject);
        }
    }

    public List<AdvertAppInfo> getAds() {
        return this.mAds;
    }
}
