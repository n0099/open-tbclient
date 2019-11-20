package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.c;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public c esp;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.esp = new c();
            this.esp.user_nickname = jSONObject.optString("user_nickname");
            this.esp.user_id = jSONObject.optLong("user_id");
            this.esp.rank = jSONObject.optInt("rank");
            this.esp.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.esp.Tx = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.esp.dGk = jSONObject.optString("point_behind");
            this.esp.user_name = jSONObject.optString("user_name");
            this.esp.dGl = jSONObject.optString("rule_url");
        }
    }
}
