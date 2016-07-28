package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private VcodeExtra ahv;
    private String vcode_md5 = null;
    private String vcode_pic_url = null;
    private String ahu = null;

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public String wJ() {
        return this.ahu;
    }

    public VcodeExtra wK() {
        return this.ahv;
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
                this.ahu = jSONObject.optString("vcode_type");
                JSONObject jSONObject2 = jSONObject.getJSONObject("vcode_extra");
                this.ahv = new VcodeExtra();
                this.ahv.textImg = jSONObject2.optString("textimg");
                this.ahv.slideImg = jSONObject2.optString("slideimg");
                this.ahv.endPoint = jSONObject2.optString("endpoint");
                this.ahv.successImg = jSONObject2.optString("successimg");
                this.ahv.slideEndPoint = jSONObject2.optString("slideendpoint");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
