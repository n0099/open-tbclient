package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public int fJJ;
    public long fJK;
    public long fJL;
    public long fJM;
    public String fJN;
    public long fJO;
    public boolean fJP;
    public boolean fJQ;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fJJ = jSONObject.optInt("current_rank");
            this.fJK = jSONObject.optInt("current_charm_value");
            this.fJL = jSONObject.optInt("up_charm_value");
            this.fJM = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.fJN = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.fJJ = hVar.rank;
            this.fJK = JavaTypesHelper.toLong(hVar.point, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.fJN = hVar.avatar;
        }
    }

    public void dI(long j) {
        this.fJL = j;
    }

    public void dJ(long j) {
        this.fJM = j;
    }

    public void kD(boolean z) {
        this.fJP = z;
    }

    public boolean bAc() {
        return this.fJP;
    }

    public void kE(boolean z) {
        this.fJQ = z;
    }

    public void dK(long j) {
        this.fJO = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.fJN)) ? false : true;
    }
}
