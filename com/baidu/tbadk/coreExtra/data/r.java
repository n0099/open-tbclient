package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private VcodeExtra arq;
    private String vcode_md5 = null;
    private String vcode_pic_url = null;
    private String arp = null;

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public String yh() {
        return this.arp;
    }

    public VcodeExtra yi() {
        return this.arq;
    }

    public void parserJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject(LoginActivityConfig.INFO);
            if (optJSONObject == null) {
                optJSONObject = jSONObject.optJSONObject("anti");
            }
            parserJson(optJSONObject);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.vcode_md5 = jSONObject.optString("vcode_md5");
                this.vcode_pic_url = jSONObject.optString("vcode_pic_url");
                this.arp = jSONObject.optString("vcode_type");
                JSONObject jSONObject2 = jSONObject.getJSONObject("vcode_extra");
                this.arq = new VcodeExtra();
                this.arq.textImg = jSONObject2.optString("textimg");
                this.arq.slideImg = jSONObject2.optString("slideimg");
                this.arq.endPoint = jSONObject2.optString("endpoint");
                this.arq.successImg = jSONObject2.optString("successimg");
                this.arq.slideEndPoint = jSONObject2.optString("slideendpoint");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
