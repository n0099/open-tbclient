package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    public int evU;
    public long evV;
    public long evW;
    public long evX;
    public String evY;
    public long evZ;
    public boolean ewa;
    public boolean ewb;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.evU = jSONObject.optInt("current_rank");
            this.evV = jSONObject.optInt("current_charm_value");
            this.evW = jSONObject.optInt("up_charm_value");
            this.evX = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.evY = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.evU = gVar.rank;
            this.evV = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.evY = gVar.avatar;
        }
    }

    public void cE(long j) {
        this.evW = j;
    }

    public void cF(long j) {
        this.evX = j;
    }

    public void ii(boolean z) {
        this.ewa = z;
    }

    public boolean bcl() {
        return this.ewa;
    }

    public void ij(boolean z) {
        this.ewb = z;
    }

    public void cG(long j) {
        this.evZ = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.evY)) ? false : true;
    }
}
