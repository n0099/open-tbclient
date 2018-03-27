package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements i {
    public static final BdUniqueId dPX = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String dPY;
    public int dPZ;
    public boolean dQa;
    public String forumId;
    public String id;
    public String portrait;
    public String score;
    public String userId;
    public String userName;

    public b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.userId = jSONObject.optString("user_id");
            this.forumId = jSONObject.optString("forum_id");
            this.score = jSONObject.optString(WBConstants.GAME_PARAMS_SCORE);
            this.createTime = jSONObject.optString(WBConstants.GAME_PARAMS_GAME_CREATE_TIME);
            this.dPY = jSONObject.optString("time_passed");
            this.content = jSONObject.optString("content");
            this.dPZ = jSONObject.optInt("zan_num");
            this.dQa = jSONObject.optInt("is_zan", 0) == 1;
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString(IntentConfig.PORTRAIT);
        }
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dPX;
    }
}
