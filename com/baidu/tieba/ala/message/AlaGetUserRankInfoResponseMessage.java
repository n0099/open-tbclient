package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h hTD;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hTD = new h();
            this.hTD.user_nickname = jSONObject.optString("user_nickname");
            this.hTD.user_id = jSONObject.optLong("user_id");
            this.hTD.rank = jSONObject.optInt("rank");
            this.hTD.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.hTD.gUA = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.hTD.gUB = jSONObject.optString("point_behind");
            this.hTD.user_name = jSONObject.optString("user_name");
            this.hTD.gUC = jSONObject.optString("rule_url");
        }
    }
}
