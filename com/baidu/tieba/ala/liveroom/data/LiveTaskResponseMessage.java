package com.baidu.tieba.ala.liveroom.data;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LiveTaskResponseMessage extends JsonHttpResponsedMessage {
    public String btnText;
    public long egq;
    public int egr;
    public String egs;
    public String egt;
    public String message;
    public String scheme;
    public String url;

    public LiveTaskResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.message = optJSONObject.optString("message");
                this.btnText = optJSONObject.optString("btnText");
                this.egq = optJSONObject.optLong("toastDuration");
                this.url = optJSONObject.optString("url");
                this.scheme = optJSONObject.optString("schema");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject2 != null) {
                this.egr = optJSONObject2.optInt("errno");
                this.egs = optJSONObject2.optString("errmsg");
                this.egt = optJSONObject2.optString("usermsg");
            }
        }
    }
}
