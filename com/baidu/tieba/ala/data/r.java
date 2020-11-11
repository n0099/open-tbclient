package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {
    public int aIc;
    public long aId;
    public long aIe;
    public long aIf;
    public boolean aIg;
    public long aIh;
    public String bdPortrait;
    public boolean gAJ;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIc = jSONObject.optInt("current_rank");
            this.aId = jSONObject.optInt("current_charm_value");
            this.aIe = jSONObject.optInt("up_charm_value");
            this.aIf = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aIc = hVar.rank;
            this.aId = JavaTypesHelper.toLong(hVar.point, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void eC(long j) {
        this.aIe = j;
    }

    public void eD(long j) {
        this.aIf = j;
    }

    public void bo(boolean z) {
        this.aIg = z;
    }

    public boolean bSe() {
        return this.aIg;
    }

    public void md(boolean z) {
        this.gAJ = z;
    }

    public void an(long j) {
        this.aIh = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
