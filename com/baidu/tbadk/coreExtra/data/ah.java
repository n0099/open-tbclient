package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private VcodeExtra eDh;
    private String vcode_md5 = null;
    private String vcode_pic_url = null;
    private String eDg = null;

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public String bnS() {
        return this.eDg;
    }

    public VcodeExtra bnT() {
        return this.eDh;
    }

    public void parserJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject == null) {
                optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI);
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
                this.eDg = jSONObject.optString("vcode_type");
                JSONObject jSONObject2 = jSONObject.getJSONObject("vcode_extra");
                this.eDh = new VcodeExtra();
                this.eDh.textImg = jSONObject2.optString("textimg");
                this.eDh.slideImg = jSONObject2.optString("slideimg");
                this.eDh.endPoint = jSONObject2.optString("endpoint");
                this.eDh.successImg = jSONObject2.optString("successimg");
                this.eDh.slideEndPoint = jSONObject2.optString("slideendpoint");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
