package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    public int eAf;
    public long eAg;
    public long eAh;
    public long eAi;
    public String eAj;
    public long eAk;
    public boolean eAl;
    public boolean eAm;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAf = jSONObject.optInt("current_rank");
            this.eAg = jSONObject.optInt("current_charm_value");
            this.eAh = jSONObject.optInt("up_charm_value");
            this.eAi = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.eAj = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.eAf = gVar.rank;
            this.eAg = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.eAj = gVar.avatar;
        }
    }

    public void cH(long j) {
        this.eAh = j;
    }

    public void cI(long j) {
        this.eAi = j;
    }

    public void ip(boolean z) {
        this.eAl = z;
    }

    public boolean beA() {
        return this.eAl;
    }

    public void iq(boolean z) {
        this.eAm = z;
    }

    public void cJ(long j) {
        this.eAk = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.eAj)) ? false : true;
    }
}
