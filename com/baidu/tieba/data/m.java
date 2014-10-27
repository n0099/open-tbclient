package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String AI;
    private String akb;
    private String akc;
    private String forumName;
    private String link;
    private String summary;
    private String title;
    private String type;
    private String userName;

    public String getLink() {
        return this.link;
    }

    public String getTitle() {
        return this.title;
    }

    public String kK() {
        return this.summary;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getType() {
        return this.type;
    }

    public String yH() {
        return this.akb;
    }

    public void parserJson(JSONObject jSONObject) {
        this.link = jSONObject.optString("link");
        this.title = jSONObject.optString("title");
        this.summary = jSONObject.optString("abstract");
        this.forumName = jSONObject.optString("forum_name");
        this.AI = jSONObject.optString("img");
        this.type = jSONObject.optString("post_type");
        this.userName = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
        this.akb = jSONObject.optString("reply_num");
        this.akc = jSONObject.optString("proper");
    }
}
