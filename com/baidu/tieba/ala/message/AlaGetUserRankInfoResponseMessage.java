package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h hVq;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hVq = new h();
            this.hVq.user_nickname = jSONObject.optString("user_nickname");
            this.hVq.user_id = jSONObject.optLong("user_id");
            this.hVq.rank = jSONObject.optInt("rank");
            this.hVq.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.hVq.gUB = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.hVq.gUC = jSONObject.optString("point_behind");
            this.hVq.user_name = jSONObject.optString("user_name");
            this.hVq.gUD = jSONObject.optString("rule_url");
        }
    }
}
