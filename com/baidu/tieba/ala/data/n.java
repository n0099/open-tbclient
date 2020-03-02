package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    public int eAg;
    public long eAh;
    public long eAi;
    public long eAj;
    public String eAk;
    public long eAl;
    public boolean eAm;
    public boolean eAn;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAg = jSONObject.optInt("current_rank");
            this.eAh = jSONObject.optInt("current_charm_value");
            this.eAi = jSONObject.optInt("up_charm_value");
            this.eAj = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.eAk = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eAg = gVar.rank;
            this.eAh = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.eAk = gVar.avatar;
        }
    }

    public void cH(long j) {
        this.eAi = j;
    }

    public void cI(long j) {
        this.eAj = j;
    }

    public void ip(boolean z) {
        this.eAm = z;
    }

    public boolean beC() {
        return this.eAm;
    }

    public void iq(boolean z) {
        this.eAn = z;
    }

    public void cJ(long j) {
        this.eAl = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.eAk)) ? false : true;
    }
}
