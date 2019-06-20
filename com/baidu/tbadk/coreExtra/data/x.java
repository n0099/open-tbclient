package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    private VcodeExtra cfy;
    private String vcode_md5 = null;
    private String vcode_pic_url = null;
    private String cfx = null;

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public String alz() {
        return this.cfx;
    }

    public VcodeExtra alA() {
        return this.cfy;
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
                this.cfx = jSONObject.optString("vcode_type");
                JSONObject jSONObject2 = jSONObject.getJSONObject("vcode_extra");
                this.cfy = new VcodeExtra();
                this.cfy.textImg = jSONObject2.optString("textimg");
                this.cfy.slideImg = jSONObject2.optString("slideimg");
                this.cfy.endPoint = jSONObject2.optString("endpoint");
                this.cfy.successImg = jSONObject2.optString("successimg");
                this.cfy.slideEndPoint = jSONObject2.optString("slideendpoint");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
