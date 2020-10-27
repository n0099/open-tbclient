package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {
    public int aHl;
    public long aHm;
    public long aHn;
    public long aHo;
    public boolean aHp;
    public long aHq;
    public String bdPortrait;
    public boolean guV;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHl = jSONObject.optInt("current_rank");
            this.aHm = jSONObject.optInt("current_charm_value");
            this.aHn = jSONObject.optInt("up_charm_value");
            this.aHo = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aHl = hVar.rank;
            this.aHm = JavaTypesHelper.toLong(hVar.point, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void eg(long j) {
        this.aHn = j;
    }

    public void eh(long j) {
        this.aHo = j;
    }

    public void bn(boolean z) {
        this.aHp = z;
    }

    public boolean bPE() {
        return this.aHp;
    }

    public void lU(boolean z) {
        this.guV = z;
    }

    public void ab(long j) {
        this.aHq = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
