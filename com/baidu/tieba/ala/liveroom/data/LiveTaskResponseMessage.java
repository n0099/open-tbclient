package com.baidu.tieba.ala.liveroom.data;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveTaskResponseMessage extends JsonHttpResponsedMessage {
    public String btnText;
    public long faY;
    public int faZ;
    public String fba;
    public String fbb;
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
                this.faY = optJSONObject.optLong("toastDuration");
                this.url = optJSONObject.optString("url");
                this.scheme = optJSONObject.optString("schema");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject2 != null) {
                this.faZ = optJSONObject2.optInt("errno");
                this.fba = optJSONObject2.optString(BaseJsonData.TAG_ERRMSG);
                this.fbb = optJSONObject2.optString("usermsg");
            }
        }
    }
}
