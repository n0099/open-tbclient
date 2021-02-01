package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h hTt;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hTt = new h();
            this.hTt.user_nickname = jSONObject.optString("user_nickname");
            this.hTt.user_id = jSONObject.optLong("user_id");
            this.hTt.rank = jSONObject.optInt("rank");
            this.hTt.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.hTt.gSE = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.hTt.gSF = jSONObject.optString("point_behind");
            this.hTt.user_name = jSONObject.optString("user_name");
            this.hTt.gSG = jSONObject.optString("rule_url");
        }
    }
}
