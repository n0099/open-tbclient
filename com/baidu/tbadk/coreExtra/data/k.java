package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private String Ro;
    private String Rp;
    private String Rq;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ro = jSONObject.optString("drop_pic");
                this.Rp = jSONObject.optString("drop_pic_md5");
                this.Rq = jSONObject.optString("drop_pic_num");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String rS() {
        return this.Ro;
    }

    public String rT() {
        return this.Rp;
    }

    public String rU() {
        return this.Rq;
    }
}
