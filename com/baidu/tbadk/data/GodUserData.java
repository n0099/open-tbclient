package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.GodInfo;
/* loaded from: classes3.dex */
public class GodUserData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 1;
    public long fid;
    public int followed;
    public Long id;
    public String intro;
    public boolean isFromNetWork = true;
    public String mForumName;
    public String mRecommendReason;
    public int type;

    public long getFid() {
        return this.fid;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public Long getId() {
        return this.id;
    }

    public String getIntro() {
        return this.intro;
    }

    public boolean getIsFromNetWork() {
        return this.isFromNetWork;
    }

    public boolean getIsLike() {
        return this.followed == 1;
    }

    public String getRecommendReason() {
        return this.mRecommendReason;
    }

    public int getType() {
        return this.type;
    }

    public boolean isBigV() {
        int i = this.type;
        return i == 2 || i == 1;
    }

    public boolean isGod() {
        return this.type == 2;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.id = Long.valueOf(jSONObject.optLong("id"));
        this.intro = jSONObject.optString("intro");
        this.type = jSONObject.optInt("type");
        this.fid = jSONObject.optLong("fid");
        this.followed = jSONObject.optInt("followed");
        this.mForumName = jSONObject.optString("forum_name");
        this.mRecommendReason = jSONObject.optString("recommend_reason");
    }

    public void parserProtobuf(GodInfo godInfo) {
        if (godInfo == null) {
            return;
        }
        this.id = godInfo.id;
        this.intro = godInfo.intro;
        this.type = godInfo.type.intValue();
        this.fid = godInfo.fid.longValue();
        this.followed = godInfo.followed.intValue();
        this.mForumName = godInfo.forum_name;
        this.mRecommendReason = godInfo.recommend_reason;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setIsFromNetWork(boolean z) {
        this.isFromNetWork = z;
    }

    public void setIsLike(boolean z) {
        this.followed = z ? 1 : 0;
    }

    public void setType(int i) {
        this.type = i;
    }
}
