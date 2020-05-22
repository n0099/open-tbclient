package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.data.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetUserRankInfoResponseMessage extends JsonHttpResponsedMessage {
    public g gjk;

    public AlaGetUserRankInfoResponseMessage() {
        super(1021070);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gjk = new g();
            this.gjk.user_nickname = jSONObject.optString("user_nickname");
            this.gjk.user_id = jSONObject.optLong("user_id");
            this.gjk.rank = jSONObject.optInt("rank");
            this.gjk.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.gjk.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
            this.gjk.fsy = jSONObject.optString("point_behind");
            this.gjk.user_name = jSONObject.optString("user_name");
            this.gjk.fsz = jSONObject.optString("rule_url");
        }
    }
}
