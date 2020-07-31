package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h gBF;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gBF = new h();
            this.gBF.user_nickname = jSONObject.optString("user_nickname");
            this.gBF.user_id = jSONObject.optLong("user_id");
            this.gBF.rank = jSONObject.optInt("rank");
            this.gBF.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.gBF.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.gBF.fJp = jSONObject.optString("point_behind");
            this.gBF.user_name = jSONObject.optString("user_name");
            this.gBF.fJq = jSONObject.optString("rule_url");
        }
    }
}
