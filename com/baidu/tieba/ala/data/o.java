package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {
    public int fVe;
    public long fVf;
    public long fVg;
    public long fVh;
    public String fVi;
    public long fVj;
    public boolean fVk;
    public boolean fVl;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fVe = jSONObject.optInt("current_rank");
            this.fVf = jSONObject.optInt("current_charm_value");
            this.fVg = jSONObject.optInt("up_charm_value");
            this.fVh = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.fVi = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.fVe = hVar.rank;
            this.fVf = JavaTypesHelper.toLong(hVar.point, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.fVi = hVar.avatar;
        }
    }

    public void dT(long j) {
        this.fVg = j;
    }

    public void dU(long j) {
        this.fVh = j;
    }

    public void ld(boolean z) {
        this.fVk = z;
    }

    public boolean bJg() {
        return this.fVk;
    }

    public void le(boolean z) {
        this.fVl = z;
    }

    public void dV(long j) {
        this.fVj = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.fVi)) ? false : true;
    }
}
