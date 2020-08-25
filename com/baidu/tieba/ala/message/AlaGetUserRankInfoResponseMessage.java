package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h gOc;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gOc = new h();
            this.gOc.user_nickname = jSONObject.optString("user_nickname");
            this.gOc.user_id = jSONObject.optLong("user_id");
            this.gOc.rank = jSONObject.optInt("rank");
            this.gOc.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.gOc.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.gOc.fUG = jSONObject.optString("point_behind");
            this.gOc.user_name = jSONObject.optString("user_name");
            this.gOc.fUH = jSONObject.optString("rule_url");
        }
    }
}
