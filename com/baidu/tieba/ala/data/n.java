package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    public int euJ;
    public long euK;
    public long euL;
    public long euM;
    public String euN;
    public long euO;
    public boolean euP;
    public boolean euQ;
    public long userId;
    public String userName;
    public String userNickname;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.euJ = jSONObject.optInt("current_rank");
            this.euK = jSONObject.optInt("current_charm_value");
            this.euL = jSONObject.optInt("up_charm_value");
            this.euM = jSONObject.optInt("down_charm_value");
            this.userId = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
            this.userName = jSONObject.optString("user_name");
            this.userNickname = jSONObject.optString("user_nickname");
            this.euN = jSONObject.optString("bd_portrait");
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.euJ = gVar.rank;
            this.euK = JavaTypesHelper.toLong(gVar.aao, 0L);
            this.userId = gVar.user_id;
            this.userName = gVar.user_name;
            this.userNickname = gVar.user_nickname;
            this.euN = gVar.avatar;
        }
    }

    public void cz(long j) {
        this.euL = j;
    }

    public void cA(long j) {
        this.euM = j;
    }

    public void hY(boolean z) {
        this.euP = z;
    }

    public boolean bbQ() {
        return this.euP;
    }

    public void hZ(boolean z) {
        this.euQ = z;
    }

    public void cB(long j) {
        this.euO = j;
    }

    public String getNameShow() {
        return !StringHelper.isEmpty(this.userNickname) ? this.userNickname : this.userName;
    }

    public boolean isValid() {
        return (StringHelper.isEmpty(getNameShow()) || StringHelper.isEmpty(this.euN)) ? false : true;
    }
}
