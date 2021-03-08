package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class r {
    public int aHY;
    public long aHZ;
    public long aIa;
    public long aIb;
    public boolean aIc;
    public long aId;
    public String bdPortrait;
    public boolean gVd;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHY = jSONObject.optInt("current_rank");
            this.aHZ = jSONObject.optInt("current_charm_value");
            this.aIa = jSONObject.optInt("up_charm_value");
            this.aIb = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aHY = hVar.rank;
            this.aHZ = JavaTypesHelper.toLong(hVar.gUB, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void fm(long j) {
        this.aIa = j;
    }

    public void fn(long j) {
        this.aIb = j;
    }

    public void bt(boolean z) {
        this.aIc = z;
    }

    public boolean bUO() {
        return this.aIc;
    }

    public void na(boolean z) {
        this.gVd = z;
    }

    public void aM(long j) {
        this.aId = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
