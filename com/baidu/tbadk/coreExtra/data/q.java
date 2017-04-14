package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private VcodeExtra apw;
    private String vcode_md5 = null;
    private String vcode_pic_url = null;
    private String apv = null;

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public String yG() {
        return this.apv;
    }

    public VcodeExtra yH() {
        return this.apw;
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
                this.vcode_md5 = jSONObject.optString(GraffitiVcodeActivityConfig.VCODE_MD5);
                this.vcode_pic_url = jSONObject.optString(GraffitiVcodeActivityConfig.VCODE_PIC_URL);
                this.apv = jSONObject.optString("vcode_type");
                JSONObject jSONObject2 = jSONObject.getJSONObject("vcode_extra");
                this.apw = new VcodeExtra();
                this.apw.textImg = jSONObject2.optString("textimg");
                this.apw.slideImg = jSONObject2.optString("slideimg");
                this.apw.endPoint = jSONObject2.optString("endpoint");
                this.apw.successImg = jSONObject2.optString("successimg");
                this.apw.slideEndPoint = jSONObject2.optString("slideendpoint");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
