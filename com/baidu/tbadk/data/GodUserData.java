package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.GodInfo;
/* loaded from: classes.dex */
public class GodUserData extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private static final long serialVersionUID = 1;
    private long fid;
    private int followed;
    private Long id;
    private String intro;
    private boolean isFromNetWork = true;
    private String mForumName;
    private String mRecommendReason;
    private int type;

    public int getFollowed() {
        return this.followed;
    }

    public long getFid() {
        return this.fid;
    }

    public int getType() {
        return this.type;
    }

    public String getIntro() {
        return this.intro;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsFromNetWork() {
        return this.isFromNetWork;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getRecommendReason() {
        return this.mRecommendReason;
    }

    public void setFollowed(int i) {
        this.followed = i;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsFromNetWork(boolean z) {
        this.isFromNetWork = z;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = Long.valueOf(jSONObject.optLong("id"));
            this.intro = jSONObject.optString("intro");
            this.type = jSONObject.optInt("type");
            this.fid = jSONObject.optLong("fid");
            this.followed = jSONObject.optInt("followed");
            this.mForumName = jSONObject.optString("forum_name");
            this.mRecommendReason = jSONObject.optString("recommend_reason");
        }
    }

    public void parserProtobuf(GodInfo godInfo) {
        if (godInfo != null) {
            this.id = godInfo.id;
            this.intro = godInfo.intro;
            this.type = godInfo.type.intValue();
            this.fid = godInfo.fid.longValue();
            this.followed = godInfo.followed.intValue();
            this.mForumName = godInfo.forum_name;
            this.mRecommendReason = godInfo.recommend_reason;
        }
    }
}
