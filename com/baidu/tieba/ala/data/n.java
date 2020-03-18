package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    public int eAP;
    public long eAQ;
    public long eAR;
    public long eAS;
    public String eAT;
    public long eAU;
    public boolean eAV;
    public boolean eAW;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAP = jSONObject.optInt("current_rank");
            this.eAQ = jSONObject.optInt("current_charm_value");
            this.eAR = jSONObject.optInt("up_charm_value");
            this.eAS = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.eAT = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eAP = gVar.rank;
            this.eAQ = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.eAT = gVar.avatar;
        }
    }

    public void cH(long j) {
        this.eAR = j;
    }

    public void cI(long j) {
        this.eAS = j;
    }

    public void ir(boolean z) {
        this.eAV = z;
    }

    public boolean beI() {
        return this.eAV;
    }

    public void is(boolean z) {
        this.eAW = z;
    }

    public void cJ(long j) {
        this.eAU = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.eAT)) ? false : true;
    }
}
