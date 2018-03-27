package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements i {
    public static final BdUniqueId dQd = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String dPY;
    public String dQe;
    public String dQf;
    public boolean dQg;
    public String forumId;
    public String id;
    public String userId;
    public String userName;

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.dQe = jSONObject.optString("main_tower_id");
            this.forumId = jSONObject.optString("forum_id");
            this.userId = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.createTime = jSONObject.optString(WBConstants.GAME_PARAMS_GAME_CREATE_TIME);
            this.content = jSONObject.optString("content");
            this.dQf = jSONObject.optString("reply_user_id");
            this.dPY = jSONObject.optString("time_passed");
            this.dQg = jSONObject.optInt("is_main_tower_user", 0) == 1;
        }
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dQd;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        return this.id.equals(((d) obj).id);
    }

    public int hashCode() {
        return 7 + (Integer.valueOf(this.id).intValue() * 31);
    }
}
