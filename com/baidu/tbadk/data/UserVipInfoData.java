package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.UserVipInfo;
/* loaded from: classes3.dex */
public class UserVipInfoData implements Serializable {
    public static final long serialVersionUID = 1412620310378890L;
    public int dayAddScore;
    public int getScore;
    public int nextLevelScore;
    public int vipEndTime;
    public String vipIconUrl;
    public int vipLevel;
    public int vipStartTime;
    public int vipStatus;

    public int getDayAddScore() {
        return this.dayAddScore;
    }

    public int getGetScore() {
        return this.getScore;
    }

    public int getNextLevelScore() {
        return this.nextLevelScore;
    }

    public int getVipEndTime() {
        return this.vipEndTime;
    }

    public String getVipIconUrl() {
        return this.vipIconUrl;
    }

    public int getVipLevel() {
        return this.vipLevel;
    }

    public int getVipStartTime() {
        return this.vipStartTime;
    }

    public int getVipStatus() {
        return this.vipStatus;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.vipStatus = jSONObject.optInt("v_status", 0);
        this.vipIconUrl = jSONObject.optString("icon_url", "");
        this.vipStartTime = jSONObject.optInt("s_time", 0);
        this.vipEndTime = jSONObject.optInt("e_time", 0);
        this.getScore = jSONObject.optInt("ext_score", 0);
        this.vipLevel = jSONObject.optInt("v_level", 0);
        this.nextLevelScore = jSONObject.optInt("n_score", 0);
        this.dayAddScore = jSONObject.optInt("a_score", 0);
    }

    public void parserProtobuf(UserVipInfo userVipInfo) {
        if (userVipInfo == null) {
            return;
        }
        Integer num = userVipInfo.v_status;
        if (num != null) {
            this.vipStatus = num.intValue();
        }
        this.vipIconUrl = userVipInfo.icon_url;
        Integer num2 = userVipInfo.s_time;
        if (num2 != null) {
            this.vipStartTime = num2.intValue();
        }
        Integer num3 = userVipInfo.e_time;
        if (num3 != null) {
            this.vipEndTime = num3.intValue();
        }
        Integer num4 = userVipInfo.ext_score;
        if (num4 != null) {
            this.getScore = num4.intValue();
        }
        Integer num5 = userVipInfo.v_level;
        if (num5 != null) {
            this.vipLevel = num5.intValue();
        }
        Integer num6 = userVipInfo.n_score;
        if (num6 != null) {
            this.nextLevelScore = num6.intValue();
        }
        Integer num7 = userVipInfo.a_score;
        if (num7 != null) {
            this.dayAddScore = num7.intValue();
        }
    }
}
