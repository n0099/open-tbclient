package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    public int fsS;
    public long fsT;
    public long fsU;
    public long fsV;
    public String fsW;
    public long fsX;
    public boolean fsY;
    public boolean fsZ;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fsS = jSONObject.optInt("current_rank");
            this.fsT = jSONObject.optInt("current_charm_value");
            this.fsU = jSONObject.optInt("up_charm_value");
            this.fsV = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.fsW = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.fsS = gVar.rank;
            this.fsT = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.fsW = gVar.avatar;
        }
    }

    public void dr(long j) {
        this.fsU = j;
    }

    public void ds(long j) {
        this.fsV = j;
    }

    public void jL(boolean z) {
        this.fsY = z;
    }

    public boolean btO() {
        return this.fsY;
    }

    public void jM(boolean z) {
        this.fsZ = z;
    }

    public void dt(long j) {
        this.fsX = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.fsW)) ? false : true;
    }
}
