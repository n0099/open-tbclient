package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class r {
    public long aGA;
    public long aGB;
    public boolean aGC;
    public long aGD;
    public int aGy;
    public long aGz;
    public String bdPortrait;
    public boolean gTg;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGy = jSONObject.optInt("current_rank");
            this.aGz = jSONObject.optInt("current_charm_value");
            this.aGA = jSONObject.optInt("up_charm_value");
            this.aGB = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aGy = hVar.rank;
            this.aGz = JavaTypesHelper.toLong(hVar.gSE, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void fm(long j) {
        this.aGA = j;
    }

    public void fn(long j) {
        this.aGB = j;
    }

    public void bt(boolean z) {
        this.aGC = z;
    }

    public boolean bUB() {
        return this.aGC;
    }

    public void na(boolean z) {
        this.gTg = z;
    }

    public void aM(long j) {
        this.aGD = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
