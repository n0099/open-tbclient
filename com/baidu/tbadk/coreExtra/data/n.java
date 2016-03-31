package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String vcode_md5 = null;
    private String vcode_pic_url = null;
    private String akq = null;

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public String yM() {
        return this.akq;
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
                this.vcode_md5 = jSONObject.optString(CommonVcodeActivityConfig.VCODE_MD5);
                this.vcode_pic_url = jSONObject.optString(CommonVcodeActivityConfig.VCODE_PIC_URL);
                this.akq = jSONObject.optString("vcode_type");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
