package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.c;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public c eth;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.eth = new c();
            this.eth.user_nickname = jSONObject.optString("user_nickname");
            this.eth.user_id = jSONObject.optLong("user_id");
            this.eth.rank = jSONObject.optInt("rank");
            this.eth.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.eth.TS = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.eth.dHb = jSONObject.optString("point_behind");
            this.eth.user_name = jSONObject.optString("user_name");
            this.eth.dHc = jSONObject.optString("rule_url");
        }
    }
}
