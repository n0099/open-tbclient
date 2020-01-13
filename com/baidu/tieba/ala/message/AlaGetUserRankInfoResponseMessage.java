package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public g fmA;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.fmA = new g();
            this.fmA.user_nickname = jSONObject.optString("user_nickname");
            this.fmA.user_id = jSONObject.optLong("user_id");
            this.fmA.rank = jSONObject.optInt("rank");
            this.fmA.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.fmA.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.fmA.evz = jSONObject.optString("point_behind");
            this.fmA.user_name = jSONObject.optString("user_name");
            this.fmA.evA = jSONObject.optString("rule_url");
        }
    }
}
