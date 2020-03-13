package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    public boolean eAA;
    public int eAt;
    public long eAu;
    public long eAv;
    public long eAw;
    public String eAx;
    public long eAy;
    public boolean eAz;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAt = jSONObject.optInt("current_rank");
            this.eAu = jSONObject.optInt("current_charm_value");
            this.eAv = jSONObject.optInt("up_charm_value");
            this.eAw = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.eAx = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eAt = gVar.rank;
            this.eAu = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.eAx = gVar.avatar;
        }
    }

    public void cH(long j) {
        this.eAv = j;
    }

    public void cI(long j) {
        this.eAw = j;
    }

    public void ip(boolean z) {
        this.eAz = z;
    }

    public boolean beD() {
        return this.eAz;
    }

    public void iq(boolean z) {
        this.eAA = z;
    }

    public void cJ(long j) {
        this.eAy = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.eAx)) ? false : true;
    }
}
