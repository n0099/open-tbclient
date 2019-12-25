package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public g fjp;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.fjp = new g();
            this.fjp.user_nickname = jSONObject.optString("user_nickname");
            this.fjp.user_id = jSONObject.optLong("user_id");
            this.fjp.rank = jSONObject.optInt("rank");
            this.fjp.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.fjp.aao = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.fjp.euo = jSONObject.optString("point_behind");
            this.fjp.user_name = jSONObject.optString("user_name");
            this.fjp.eup = jSONObject.optString("rule_url");
        }
    }
}
