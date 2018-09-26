package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.ar.paddle.PaddleController;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId dHf = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String dHg;
    public int dHh;
    public boolean dHi;
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
            this.score = jSONObject.optString(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.createTime = jSONObject.optString("create_time");
            this.dHg = jSONObject.optString("time_passed");
            this.content = jSONObject.optString("content");
            this.dHh = jSONObject.optInt("zan_num");
            this.dHi = jSONObject.optInt("is_zan", 0) == 1;
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString(IntentConfig.PORTRAIT);
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dHf;
    }
}
