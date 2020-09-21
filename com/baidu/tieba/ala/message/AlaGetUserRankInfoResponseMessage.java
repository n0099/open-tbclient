package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public h gRw;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gRw = new h();
            this.gRw.user_nickname = jSONObject.optString("user_nickname");
            this.gRw.user_id = jSONObject.optLong("user_id");
            this.gRw.rank = jSONObject.optInt("rank");
            this.gRw.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.gRw.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.gRw.fXZ = jSONObject.optString("point_behind");
            this.gRw.user_name = jSONObject.optString("user_name");
            this.gRw.fYa = jSONObject.optString("rule_url");
        }
    }
}
