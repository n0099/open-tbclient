package com.baidu.tbadk.util;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CheckBaiduSimResponseMessage extends JsonHttpResponsedMessage {
    public boolean isBaiduSim;
    public boolean isSuc;

    public CheckBaiduSimResponseMessage() {
        super(1003392);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.isSuc = jSONObject.optInt("status") == 0;
            this.isBaiduSim = jSONObject.optInt(BdStatsConstant.StatsKey.PRODUCT) == 1;
        }
    }
}
