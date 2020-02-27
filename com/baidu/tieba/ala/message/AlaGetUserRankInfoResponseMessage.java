package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public g fpd;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.fpd = new g();
            this.fpd.user_nickname = jSONObject.optString("user_nickname");
            this.fpd.user_id = jSONObject.optLong("user_id");
            this.fpd.rank = jSONObject.optInt("rank");
            this.fpd.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.fpd.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.fpd.ezK = jSONObject.optString("point_behind");
            this.fpd.user_name = jSONObject.optString("user_name");
            this.fpd.ezL = jSONObject.optString("rule_url");
        }
    }
}
