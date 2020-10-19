package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {
    public int aHa;
    public long aHb;
    public long aHc;
    public long aHd;
    public String bdPortrait;
    public long gkO;
    public boolean gkP;
    public boolean gkQ;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHa = jSONObject.optInt("current_rank");
            this.aHb = jSONObject.optInt("current_charm_value");
            this.aHc = jSONObject.optInt("up_charm_value");
            this.aHd = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aHa = hVar.rank;
            this.aHb = JavaTypesHelper.toLong(hVar.point, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void ee(long j) {
        this.aHc = j;
    }

    public void ef(long j) {
        this.aHd = j;
    }

    public void lD(boolean z) {
        this.gkP = z;
    }

    public boolean bMZ() {
        return this.gkP;
    }

    public void lE(boolean z) {
        this.gkQ = z;
    }

    public void eg(long j) {
        this.gkO = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
