package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public int dHs;
    public long dHt;
    public long dHu;
    public long dHv;
    public String dHw;
    public long dHx;
    public boolean dHy;
    public boolean dHz;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dHs = jSONObject.optInt("current_rank");
            this.dHt = jSONObject.optInt("current_charm_value");
            this.dHu = jSONObject.optInt("up_charm_value");
            this.dHv = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.dHw = jSONObject.optString("bd_portrait");
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.dHs = cVar.rank;
            this.dHt = JavaTypesHelper.toLong(cVar.TS, 0L);
            this.userId = cVar.user_id;
            this.userName = cVar.user_name;
            this.userNickname = cVar.user_nickname;
            this.dHw = cVar.avatar;
        }
    }

    public void bW(long j) {
        this.dHu = j;
    }

    public void bX(long j) {
        this.dHv = j;
    }

    public void gR(boolean z) {
        this.dHy = z;
    }

    public boolean aKG() {
        return this.dHy;
    }

    public void gS(boolean z) {
        this.dHz = z;
    }

    public void bY(long j) {
        this.dHx = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.dHw)) ? false : true;
    }
}
