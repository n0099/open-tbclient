package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h gOg;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gOg = new h();
            this.gOg.user_nickname = jSONObject.optString("user_nickname");
            this.gOg.user_id = jSONObject.optLong("user_id");
            this.gOg.rank = jSONObject.optInt("rank");
            this.gOg.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.gOg.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.gOg.fUK = jSONObject.optString("point_behind");
            this.gOg.user_name = jSONObject.optString("user_name");
            this.gOg.fUL = jSONObject.optString("rule_url");
        }
    }
}
