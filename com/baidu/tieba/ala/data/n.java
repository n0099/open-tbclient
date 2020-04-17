package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    public int ffi;
    public long ffj;
    public long ffk;
    public long ffl;
    public String ffm;
    public long ffn;
    public boolean ffo;
    public boolean ffp;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ffi = jSONObject.optInt("current_rank");
            this.ffj = jSONObject.optInt("current_charm_value");
            this.ffk = jSONObject.optInt("up_charm_value");
            this.ffl = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.ffm = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.ffi = gVar.rank;
            this.ffj = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.ffm = gVar.avatar;
        }
    }

    public void dp(long j) {
        this.ffk = j;
    }

    public void dq(long j) {
        this.ffl = j;
    }

    public void js(boolean z) {
        this.ffo = z;
    }

    public boolean bnY() {
        return this.ffo;
    }

    public void jt(boolean z) {
        this.ffp = z;
    }

    public void dr(long j) {
        this.ffn = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.ffm)) ? false : true;
    }
}
