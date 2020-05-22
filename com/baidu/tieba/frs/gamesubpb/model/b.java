package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ar.gesture.GestureAR;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements o {
    public static final BdUniqueId hCW = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String forumId;
    public String hCX;
    public int hCY;
    public boolean hCZ;
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
            this.hCX = jSONObject.optString("time_passed");
            this.content = jSONObject.optString("content");
            this.hCY = jSONObject.optInt("zan_num");
            this.hCZ = jSONObject.optInt("is_zan", 0) == 1;
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString("portrait");
        }
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hCW;
    }
}
