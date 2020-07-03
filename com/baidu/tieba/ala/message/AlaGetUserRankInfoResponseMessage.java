package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public g gwi;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gwi = new g();
            this.gwi.user_nickname = jSONObject.optString("user_nickname");
            this.gwi.user_id = jSONObject.optLong("user_id");
            this.gwi.rank = jSONObject.optInt("rank");
            this.gwi.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.gwi.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.gwi.fDU = jSONObject.optString("point_behind");
            this.gwi.user_name = jSONObject.optString("user_name");
            this.gwi.fDV = jSONObject.optString("rule_url");
        }
    }
}
