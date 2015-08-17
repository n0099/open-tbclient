package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String ahm;
    private String ahn;
    private String aho;
    private String ahp;
    private String ahq;
    private String ahr;
    private String ahs;
    private String aht;
    private int ahu;
    private String ahv;
    private String ahw;
    private String ahx;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ahm = jSONObject.optString("drop_pic");
                this.ahn = jSONObject.optString("drop_pic_md5");
                this.aho = jSONObject.optString("drop_pic_num");
                this.ahp = jSONObject.optString("drop_bg_color_day");
                this.ahq = jSONObject.optString("drop_bg_color_night");
                this.ahr = jSONObject.optString("apply_vip_live_room_pid");
                this.ahv = jSONObject.optString("max_cache");
                this.ahw = jSONObject.optString("frs_max_cache");
                this.ahx = jSONObject.optString("frs_pn");
                this.ahs = jSONObject.optString("tail_link");
                this.aht = jSONObject.optString("bubble_link");
                this.ahu = jSONObject.optInt("xiaoying_time");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String wE() {
        return this.ahr;
    }

    public String wF() {
        return this.ahm;
    }

    public String wG() {
        return this.ahn;
    }

    public String wH() {
        return this.aho;
    }

    public String wI() {
        return this.ahp;
    }

    public String wJ() {
        return this.ahq;
    }

    public String wK() {
        return this.ahv;
    }

    public String wL() {
        return this.ahw;
    }

    public String wM() {
        return this.ahx;
    }

    public String wN() {
        return this.ahs;
    }

    public String wO() {
        return this.aht;
    }

    public int wP() {
        return this.ahu;
    }
}
