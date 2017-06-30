package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private VcodeExtra aqk;
    private String vcode_md5 = null;
    private String vcode_pic_url = null;
    private String aqj = null;

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public String ye() {
        return this.aqj;
    }

    public VcodeExtra yf() {
        return this.aqk;
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
                this.aqj = jSONObject.optString("vcode_type");
                JSONObject jSONObject2 = jSONObject.getJSONObject("vcode_extra");
                this.aqk = new VcodeExtra();
                this.aqk.textImg = jSONObject2.optString("textimg");
                this.aqk.slideImg = jSONObject2.optString("slideimg");
                this.aqk.endPoint = jSONObject2.optString("endpoint");
                this.aqk.successImg = jSONObject2.optString("successimg");
                this.aqk.slideEndPoint = jSONObject2.optString("slideendpoint");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
