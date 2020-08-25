package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.UserVipInfo;
/* loaded from: classes2.dex */
public class UserVipInfoData implements Serializable {
    private static final long serialVersionUID = 1412620310378890L;
    private int dayAddScore;
    private int getScore;
    private int nextLevelScore;
    private int vipEndTime;
    private String vipIconUrl;
    private int vipLevel;
    private int vipStartTime;
    private int vipStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.vipStatus = jSONObject.optInt("v_status", 0);
            this.vipIconUrl = jSONObject.optString("icon_url", "");
            this.vipStartTime = jSONObject.optInt("s_time", 0);
            this.vipEndTime = jSONObject.optInt("e_time", 0);
            this.getScore = jSONObject.optInt("ext_score", 0);
            this.vipLevel = jSONObject.optInt("v_level", 0);
            this.nextLevelScore = jSONObject.optInt("n_score", 0);
            this.dayAddScore = jSONObject.optInt("a_score", 0);
        }
    }

    public void parserProtobuf(UserVipInfo userVipInfo) {
        if (userVipInfo != null) {
            if (userVipInfo.v_status != null) {
                this.vipStatus = userVipInfo.v_status.intValue();
            }
            this.vipIconUrl = userVipInfo.icon_url;
            if (userVipInfo.s_time != null) {
                this.vipStartTime = userVipInfo.s_time.intValue();
            }
            if (userVipInfo.e_time != null) {
                this.vipEndTime = userVipInfo.e_time.intValue();
            }
            if (userVipInfo.ext_score != null) {
                this.getScore = userVipInfo.ext_score.intValue();
            }
            if (userVipInfo.v_level != null) {
                this.vipLevel = userVipInfo.v_level.intValue();
            }
            if (userVipInfo.n_score != null) {
                this.nextLevelScore = userVipInfo.n_score.intValue();
            }
            if (userVipInfo.a_score != null) {
                this.dayAddScore = userVipInfo.a_score.intValue();
            }
        }
    }

    public int getVipStatus() {
        return this.vipStatus;
    }

    public String getVipIconUrl() {
        return this.vipIconUrl;
    }

    public int getVipStartTime() {
        return this.vipStartTime;
    }

    public int getVipEndTime() {
        return this.vipEndTime;
    }

    public int getGetScore() {
        return this.getScore;
    }

    public int getVipLevel() {
        return this.vipLevel;
    }

    public int getNextLevelScore() {
        return this.nextLevelScore;
    }

    public int getDayAddScore() {
        return this.dayAddScore;
    }
}
