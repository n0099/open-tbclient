package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {
    public int aGr;
    public long aGs;
    public long aGt;
    public long aGu;
    public boolean aGv;
    public long aGw;
    public String bdPortrait;
    public boolean gAq;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGr = jSONObject.optInt("current_rank");
            this.aGs = jSONObject.optInt("current_charm_value");
            this.aGt = jSONObject.optInt("up_charm_value");
            this.aGu = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aGr = hVar.rank;
            this.aGs = JavaTypesHelper.toLong(hVar.point, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void eC(long j) {
        this.aGt = j;
    }

    public void eD(long j) {
        this.aGu = j;
    }

    public void bq(boolean z) {
        this.aGv = z;
    }

    public boolean bRx() {
        return this.aGv;
    }

    public void me(boolean z) {
        this.gAq = z;
    }

    public void an(long j) {
        this.aGw = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
