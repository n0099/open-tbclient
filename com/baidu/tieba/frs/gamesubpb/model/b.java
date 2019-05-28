package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements m {
    public static final BdUniqueId fDR = BdUniqueId.gen();
    public String content;
    public String createTime;
    public String fDS;
    public int fDT;
    public boolean fDU;
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
            this.score = jSONObject.optString("score");
            this.createTime = jSONObject.optString("create_time");
            this.fDS = jSONObject.optString("time_passed");
            this.content = jSONObject.optString("content");
            this.fDT = jSONObject.optInt("zan_num");
            this.fDU = jSONObject.optInt("is_zan", 0) == 1;
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString(IntentConfig.PORTRAIT);
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fDR;
    }
}
