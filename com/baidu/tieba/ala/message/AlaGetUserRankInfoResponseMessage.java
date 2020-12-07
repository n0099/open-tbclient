package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h hHB;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hHB = new h();
            this.hHB.user_nickname = jSONObject.optString("user_nickname");
            this.hHB.user_id = jSONObject.optLong("user_id");
            this.hHB.rank = jSONObject.optInt("rank");
            this.hHB.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.hHB.gIM = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.hHB.gIN = jSONObject.optString("point_behind");
            this.hHB.user_name = jSONObject.optString("user_name");
            this.hHB.gIO = jSONObject.optString("rule_url");
        }
    }
}
