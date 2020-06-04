package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    public int ftd;
    public long fte;
    public long ftf;
    public long ftg;
    public String fth;
    public long fti;
    public boolean ftj;
    public boolean ftk;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ftd = jSONObject.optInt("current_rank");
            this.fte = jSONObject.optInt("current_charm_value");
            this.ftf = jSONObject.optInt("up_charm_value");
            this.ftg = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.fth = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.ftd = gVar.rank;
            this.fte = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.fth = gVar.avatar;
        }
    }

    public void dr(long j) {
        this.ftf = j;
    }

    public void ds(long j) {
        this.ftg = j;
    }

    public void jL(boolean z) {
        this.ftj = z;
    }

    public boolean btQ() {
        return this.ftj;
    }

    public void jM(boolean z) {
        this.ftk = z;
    }

    public void dt(long j) {
        this.fti = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.fth)) ? false : true;
    }
}
