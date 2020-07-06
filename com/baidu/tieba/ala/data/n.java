package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    public int fEo;
    public long fEp;
    public long fEq;
    public long fEr;
    public String fEs;
    public long fEt;
    public boolean fEu;
    public boolean fEv;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fEo = jSONObject.optInt("current_rank");
            this.fEp = jSONObject.optInt("current_charm_value");
            this.fEq = jSONObject.optInt("up_charm_value");
            this.fEr = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.fEs = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.fEo = gVar.rank;
            this.fEp = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.fEs = gVar.avatar;
        }
    }

    public void du(long j) {
        this.fEq = j;
    }

    public void dv(long j) {
        this.fEr = j;
    }

    public void jZ(boolean z) {
        this.fEu = z;
    }

    public boolean bwM() {
        return this.fEu;
    }

    public void ka(boolean z) {
        this.fEv = z;
    }

    public void dw(long j) {
        this.fEt = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.fEs)) ? false : true;
    }
}
