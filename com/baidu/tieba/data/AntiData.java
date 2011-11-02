package com.baidu.tieba.data;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AntiData {
    private int forbid_flag;
    private String forbid_info;
    private int ifpost;
    private int ifposta;
    private int need_vcode;
    private String tbs;
    private String vcode_md5;
    private String vcode_pic_url;

    public int getIfpost() {
        return this.ifpost;
    }

    public void setIfpost(int ifpost) {
        this.ifpost = ifpost;
    }

    public int getIfposta() {
        return this.ifposta;
    }

    public void setIfposta(int ifposta) {
        this.ifposta = ifposta;
    }

    public int getForbid_flag() {
        return this.forbid_flag;
    }

    public void setForbid_flag(int forbid_flag) {
        this.forbid_flag = forbid_flag;
    }

    public String getTbs() {
        return this.tbs;
    }

    public void setTbs(String tbs) {
        this.tbs = tbs;
    }

    public int getNeed_vcode() {
        return this.need_vcode;
    }

    public void setNeed_vcode(int need_vcode) {
        this.need_vcode = need_vcode;
    }

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public void setVcode_md5(String vcode_md5) {
        this.vcode_md5 = vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public void setVcode_pic_url(String url) {
        this.vcode_pic_url = url;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("AntiData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.ifpost = json.optInt("ifpost", 0);
                this.ifposta = json.optInt("ifposta", 0);
                this.forbid_flag = json.optInt("forbid_flag", 0);
                this.tbs = json.optString("tbs");
                if (TiebaApplication.app != null && this.tbs != null && this.tbs.length() > 0) {
                    TiebaApplication.app.setTbs(this.tbs);
                }
                this.need_vcode = json.optInt("need_vcode", 0);
                this.vcode_md5 = json.optString("vcode_md5");
                this.vcode_pic_url = json.optString("vcode_pic_url");
                this.forbid_info = json.optString("forbid_info");
            } catch (Exception ex) {
                TiebaLog.e("AntiData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("AntiData", "logPrint", "ifpost = " + String.valueOf(this.ifpost));
        TiebaLog.v("AntiData", "logPrint", "ifposta = " + String.valueOf(this.ifposta));
        TiebaLog.v("AntiData", "logPrint", "forbid_flag = " + String.valueOf(this.forbid_flag));
        TiebaLog.v("AntiData", "logPrint", "tbs = " + this.tbs);
        TiebaLog.v("AntiData", "logPrint", "need_vcode = " + String.valueOf(this.need_vcode));
        TiebaLog.v("AntiData", "logPrint", "vcode_md5 = " + this.vcode_md5);
    }

    public void setForbid_info(String forbid_info) {
        this.forbid_info = forbid_info;
    }

    public String getForbid_info() {
        return this.forbid_info;
    }
}
