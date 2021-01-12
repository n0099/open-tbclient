package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements n {
    public static final BdUniqueId jvF = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String forumId;
    public String id;
    public String jvA;
    public String jvG;
    public String jvH;
    public boolean jvI;
    public String userId;
    public String userName;

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.jvG = jSONObject.optString("main_tower_id");
            this.forumId = jSONObject.optString("forum_id");
            this.userId = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.createTime = jSONObject.optString("create_time");
            this.content = jSONObject.optString("content");
            this.jvH = jSONObject.optString("reply_user_id");
            this.jvA = jSONObject.optString("time_passed");
            this.jvI = jSONObject.optInt("is_main_tower_user", 0) == 1;
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jvF;
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
