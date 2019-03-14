package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId fnP = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String fnK;
    public String fnQ;
    public String fnR;
    public boolean fnS;
    public String forumId;
    public String id;
    public String userId;
    public String userName;

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.fnQ = jSONObject.optString("main_tower_id");
            this.forumId = jSONObject.optString("forum_id");
            this.userId = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.createTime = jSONObject.optString("create_time");
            this.content = jSONObject.optString("content");
            this.fnR = jSONObject.optString("reply_user_id");
            this.fnK = jSONObject.optString("time_passed");
            this.fnS = jSONObject.optInt("is_main_tower_user", 0) == 1;
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fnP;
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
