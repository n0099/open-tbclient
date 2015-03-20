package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private String aaX;
    private String aaY;
    private String aaZ;
    private String aba;
    private String abb;
    private String abc;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aaX = jSONObject.optString("drop_pic");
                this.aaY = jSONObject.optString("drop_pic_md5");
                this.aaZ = jSONObject.optString("drop_pic_num");
                this.aba = jSONObject.optString("drop_bg_color_day");
                this.abb = jSONObject.optString("drop_bg_color_night");
                this.abc = jSONObject.optString("apply_vip_live_room_pid");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String uK() {
        return this.abc;
    }

    public String uL() {
        return this.aaX;
    }

    public String uM() {
        return this.aaY;
    }

    public String uN() {
        return this.aaZ;
    }

    public String uO() {
        return this.aba;
    }

    public String uP() {
        return this.abb;
    }
}
