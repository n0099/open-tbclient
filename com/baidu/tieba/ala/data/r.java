package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {
    public int aJa;
    public long aJb;
    public long aJc;
    public long aJd;
    public boolean aJe;
    public long aJf;
    public String bdPortrait;
    public boolean gJp;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJa = jSONObject.optInt("current_rank");
            this.aJb = jSONObject.optInt("current_charm_value");
            this.aJc = jSONObject.optInt("up_charm_value");
            this.aJd = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.bdPortrait = jSONObject.optString("bd_portrait");
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.aJa = hVar.rank;
            this.aJb = JavaTypesHelper.toLong(hVar.gIO, 0L);
            this.userId = hVar.user_id;
            this.userName = hVar.user_name;
            this.userNickname = hVar.user_nickname;
            this.bdPortrait = hVar.avatar;
        }
    }

    public void fg(long j) {
        this.aJc = j;
    }

    public void fh(long j) {
        this.aJd = j;
    }

    public void by(boolean z) {
        this.aJe = z;
    }

    public boolean bVi() {
        return this.aJe;
    }

    public void mz(boolean z) {
        this.gJp = z;
    }

    public void aL(long j) {
        this.aJf = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.bdPortrait)) ? false : true;
    }
}
