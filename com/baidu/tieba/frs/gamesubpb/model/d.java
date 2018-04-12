package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements h {
    public static final BdUniqueId dkr = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String dkm;
    public String dks;
    public String dkt;
    public boolean dku;
    public String forumId;
    public String id;
    public String userId;
    public String userName;

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.dks = jSONObject.optString("main_tower_id");
            this.forumId = jSONObject.optString("forum_id");
            this.userId = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.createTime = jSONObject.optString(WBConstants.GAME_PARAMS_GAME_CREATE_TIME);
            this.content = jSONObject.optString("content");
            this.dkt = jSONObject.optString("reply_user_id");
            this.dkm = jSONObject.optString("time_passed");
            this.dku = jSONObject.optInt("is_main_tower_user", 0) == 1;
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dkr;
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
