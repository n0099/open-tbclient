package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {
    public int fVa;
    public long fVb;
    public long fVc;
    public long fVd;
    public String fVe;
    public long fVf;
    public boolean fVg;
    public boolean fVh;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fVa = jSONObject.optInt("current_rank");
            this.fVb = jSONObject.optInt("current_charm_value");
            this.fVc = jSONObject.optInt("up_charm_value");
            this.fVd = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.fVe = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.fVa = hVar.rank;
            this.fVb = JavaTypesHelper.toLong(hVar.point, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.fVe = hVar.avatar;
        }
    }

    public void dT(long j) {
        this.fVc = j;
    }

    public void dU(long j) {
        this.fVd = j;
    }

    public void lb(boolean z) {
        this.fVg = z;
    }

    public boolean bJf() {
        return this.fVg;
    }

    public void lc(boolean z) {
        this.fVh = z;
    }

    public void dV(long j) {
        this.fVf = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.fVe)) ? false : true;
    }
}
