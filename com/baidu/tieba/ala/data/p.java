package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {
    public int aDW;
    public long aDX;
    public long aDY;
    public long aDZ;
    public String bdPortrait;
    public long fYw;
    public boolean fYx;
    public boolean fYy;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDW = jSONObject.optInt("current_rank");
            this.aDX = jSONObject.optInt("current_charm_value");
            this.aDY = jSONObject.optInt("up_charm_value");
            this.aDZ = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aDW = hVar.rank;
            this.aDX = JavaTypesHelper.toLong(hVar.point, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void dV(long j) {
        this.aDY = j;
    }

    public void dW(long j) {
        this.aDZ = j;
    }

    public void lf(boolean z) {
        this.fYx = z;
    }

    public boolean bKp() {
        return this.fYx;
    }

    public void lg(boolean z) {
        this.fYy = z;
    }

    public void dX(long j) {
        this.fYw = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
