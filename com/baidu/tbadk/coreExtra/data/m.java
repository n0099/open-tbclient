package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String ahA;
    private String ahB;
    private String ahC;
    private String ahD;
    private int ahE;
    private String ahF;
    private String ahG;
    private String ahH;
    private String ahw;
    private String ahx;
    private String ahy;
    private String ahz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ahw = jSONObject.optString("drop_pic");
                this.ahx = jSONObject.optString("drop_pic_md5");
                this.ahy = jSONObject.optString("drop_pic_num");
                this.ahz = jSONObject.optString("drop_bg_color_day");
                this.ahA = jSONObject.optString("drop_bg_color_night");
                this.ahB = jSONObject.optString("apply_vip_live_room_pid");
                this.ahF = jSONObject.optString("max_cache");
                this.ahG = jSONObject.optString("frs_max_cache");
                this.ahH = jSONObject.optString("frs_pn");
                this.ahC = jSONObject.optString("tail_link");
                this.ahD = jSONObject.optString("bubble_link");
                this.ahE = jSONObject.optInt("xiaoying_time");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String wK() {
        return this.ahB;
    }

    public String wL() {
        return this.ahw;
    }

    public String wM() {
        return this.ahx;
    }

    public String wN() {
        return this.ahy;
    }

    public String wO() {
        return this.ahz;
    }

    public String wP() {
        return this.ahA;
    }

    public String wQ() {
        return this.ahF;
    }

    public String wR() {
        return this.ahG;
    }

    public String wS() {
        return this.ahH;
    }

    public String wT() {
        return this.ahC;
    }

    public String wU() {
        return this.ahD;
    }

    public int wV() {
        return this.ahE;
    }
}
