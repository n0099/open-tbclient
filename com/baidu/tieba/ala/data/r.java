package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class r {
    public int aEL;
    public long aEM;
    public long aEN;
    public long aEO;
    public boolean aEP;
    public long aEQ;
    public String bdPortrait;
    public boolean gQw;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aEL = jSONObject.optInt("current_rank");
            this.aEM = jSONObject.optInt("current_charm_value");
            this.aEN = jSONObject.optInt("up_charm_value");
            this.aEO = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aEL = hVar.rank;
            this.aEM = JavaTypesHelper.toLong(hVar.gPU, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void fg(long j) {
        this.aEN = j;
    }

    public void fh(long j) {
        this.aEO = j;
    }

    public void br(boolean z) {
        this.aEP = z;
    }

    public boolean bTW() {
        return this.aEP;
    }

    public void mV(boolean z) {
        this.gQw = z;
    }

    public void aK(long j) {
        this.aEQ = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
