package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    public int ffn;
    public long ffo;
    public long ffp;
    public long ffq;
    public String ffr;
    public long ffs;
    public boolean fft;
    public boolean ffu;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ffn = jSONObject.optInt("current_rank");
            this.ffo = jSONObject.optInt("current_charm_value");
            this.ffp = jSONObject.optInt("up_charm_value");
            this.ffq = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.ffr = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.ffn = gVar.rank;
            this.ffo = JavaTypesHelper.toLong(gVar.point, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.ffr = gVar.avatar;
        }
    }

    public void dp(long j) {
        this.ffp = j;
    }

    public void dq(long j) {
        this.ffq = j;
    }

    public void js(boolean z) {
        this.fft = z;
    }

    public boolean bnW() {
        return this.fft;
    }

    public void jt(boolean z) {
        this.ffu = z;
    }

    public void dr(long j) {
        this.ffs = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.ffr)) ? false : true;
    }
}
