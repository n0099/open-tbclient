package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ar.gesture.GestureAR;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId jDc = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String forumId;
    public String id;
    public String jDd;
    public int jDe;
    public boolean jDf;
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
            this.jDd = jSONObject.optString("time_passed");
            this.content = jSONObject.optString("content");
            this.jDe = jSONObject.optInt("zan_num");
            this.jDf = jSONObject.optInt("is_zan", 0) == 1;
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString("portrait");
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jDc;
    }
}
