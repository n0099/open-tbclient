package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public int dGB;
    public long dGC;
    public long dGD;
    public long dGE;
    public String dGF;
    public long dGG;
    public boolean dGH;
    public boolean dGI;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dGB = jSONObject.optInt("current_rank");
            this.dGC = jSONObject.optInt("current_charm_value");
            this.dGD = jSONObject.optInt("up_charm_value");
            this.dGE = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.dGF = jSONObject.optString("bd_portrait");
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.dGB = cVar.rank;
            this.dGC = JavaTypesHelper.toLong(cVar.Tx, 0L);
            this.userId = cVar.user_id;
            this.userName = cVar.user_name;
            this.userNickname = cVar.user_nickname;
            this.dGF = cVar.avatar;
        }
    }

    public void bV(long j) {
        this.dGD = j;
    }

    public void bW(long j) {
        this.dGE = j;
    }

    public void gR(boolean z) {
        this.dGH = z;
    }

    public boolean aKE() {
        return this.dGH;
    }

    public void gS(boolean z) {
        this.dGI = z;
    }

    public void bX(long j) {
        this.dGG = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.dGF)) ? false : true;
    }
}
