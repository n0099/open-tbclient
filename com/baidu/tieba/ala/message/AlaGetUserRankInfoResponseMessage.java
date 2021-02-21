package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h hTH;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hTH = new h();
            this.hTH.user_nickname = jSONObject.optString("user_nickname");
            this.hTH.user_id = jSONObject.optLong("user_id");
            this.hTH.rank = jSONObject.optInt("rank");
            this.hTH.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.hTH.gSS = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.hTH.gST = jSONObject.optString("point_behind");
            this.hTH.user_name = jSONObject.optString("user_name");
            this.hTH.gSU = jSONObject.optString("rule_url");
        }
    }
}
