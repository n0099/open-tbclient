package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private String Rl;
    private String Rm;
    private String Rn;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Rl = jSONObject.optString("drop_pic");
                this.Rm = jSONObject.optString("drop_pic_md5");
                this.Rn = jSONObject.optString("drop_pic_num");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String rM() {
        return this.Rl;
    }

    public String rN() {
        return this.Rm;
    }

    public String rO() {
        return this.Rn;
    }
}
