package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ar.gesture.GestureAR;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class b implements q {
    public static final BdUniqueId iHa = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String forumId;
    public String iHb;
    public int iHc;
    public boolean iHd;
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
            this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.createTime = jSONObject.optString("create_time");
            this.iHb = jSONObject.optString("time_passed");
            this.content = jSONObject.optString("content");
            this.iHc = jSONObject.optInt("zan_num");
            this.iHd = jSONObject.optInt("is_zan", 0) == 1;
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString("portrait");
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iHa;
    }
}
