package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d implements q {
    public static final BdUniqueId hQX = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String forumId;
    public String hQS;
    public String hQY;
    public String hQZ;
    public boolean hRa;
    public String id;
    public String userId;
    public String userName;

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.hQY = jSONObject.optString("main_tower_id");
            this.forumId = jSONObject.optString("forum_id");
            this.userId = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.createTime = jSONObject.optString("create_time");
            this.content = jSONObject.optString("content");
            this.hQZ = jSONObject.optString("reply_user_id");
            this.hQS = jSONObject.optString("time_passed");
            this.hRa = jSONObject.optInt("is_main_tower_user", 0) == 1;
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hQX;
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
