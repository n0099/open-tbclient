package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.LikeForumInfo;
/* loaded from: classes.dex */
public class MyLikeForum extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private static final long serialVersionUID = 1;
    private long mForumId;
    private String mForumName;

    public String getForumName() {
        return this.mForumName;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mForumId = jSONObject.optLong("forum_id");
            this.mForumName = jSONObject.optString("forum_name");
        }
    }

    public void parserProtobuf(LikeForumInfo likeForumInfo) {
        if (likeForumInfo != null) {
            this.mForumId = likeForumInfo.forum_id.longValue();
            this.mForumName = likeForumInfo.forum_name;
        }
    }
}
