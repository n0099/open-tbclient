package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h hgt;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hgt = new h();
            this.hgt.user_nickname = jSONObject.optString("user_nickname");
            this.hgt.user_id = jSONObject.optLong("user_id");
            this.hgt.rank = jSONObject.optInt("rank");
            this.hgt.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.hgt.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.hgt.gkr = jSONObject.optString("point_behind");
            this.hgt.user_name = jSONObject.optString("user_name");
            this.hgt.gks = jSONObject.optString("rule_url");
        }
    }
}
