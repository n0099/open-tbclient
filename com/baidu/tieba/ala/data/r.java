package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class r {
    public long aJA;
    public long aJB;
    public boolean aJC;
    public long aJD;
    public int aJy;
    public long aJz;
    public String bdPortrait;
    public boolean gVc;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJy = jSONObject.optInt("current_rank");
            this.aJz = jSONObject.optInt("current_charm_value");
            this.aJA = jSONObject.optInt("up_charm_value");
            this.aJB = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aJy = hVar.rank;
            this.aJz = JavaTypesHelper.toLong(hVar.gUA, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void fg(long j) {
        this.aJA = j;
    }

    public void fh(long j) {
        this.aJB = j;
    }

    public void bv(boolean z) {
        this.aJC = z;
    }

    public boolean bXN() {
        return this.aJC;
    }

    public void mZ(boolean z) {
        this.gVc = z;
    }

    public void aK(long j) {
        this.aJD = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
