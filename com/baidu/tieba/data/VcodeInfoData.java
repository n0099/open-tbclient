package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeInfoData {
    private String vcode_md5 = null;
    private String vcode_pic_url = null;

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public void setVcode_md5(String vcode_md5) {
        this.vcode_md5 = vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public void setVcode_pic_url(String vcode_pic_url) {
        this.vcode_pic_url = vcode_pic_url;
    }

    public void parserJson(String str) {
        try {
            JSONObject json = new JSONObject(str);
            JSONObject data = json.optJSONObject("info");
            if (data == null) {
                data = json.optJSONObject("anti");
            }
            parserJson(data);
        } catch (Exception ex) {
            TiebaLog.e("VcodeInfoData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.vcode_md5 = json.optString("vcode_md5");
                this.vcode_pic_url = json.optString("vcode_pic_url");
            } catch (Exception ex) {
                TiebaLog.e("VcodeInfoData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("VcodeInfoData", "logPrint", "vcode_md5 = " + this.vcode_md5);
        TiebaLog.v("VcodeInfoData", "logPrint", "vcode_pic_url = " + this.vcode_pic_url);
    }
}
