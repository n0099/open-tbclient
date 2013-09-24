package com.baidu.tieba.data;

import com.baidu.tieba.TiebaApplication;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AntiData implements Serializable {
    private static final long serialVersionUID = 2355009973517935888L;
    private int forbid_flag;
    private String forbid_info;
    private int ifpost;
    private int ifposta;
    private int ifvoice = 1;
    private int need_vcode;
    private String tbs;
    private String vcode_md5;
    private String vcode_pic_url;
    private String voice_message;

    public boolean isIfvoice() {
        return this.ifvoice == 1;
    }

    public void setIfVoice(boolean z) {
        this.ifvoice = z ? 1 : 0;
    }

    public String getVoice_message() {
        return this.voice_message;
    }

    public int getIfpost() {
        return this.ifpost;
    }

    public void setIfpost(int i) {
        this.ifpost = i;
    }

    public int getIfposta() {
        return this.ifposta;
    }

    public void setIfposta(int i) {
        this.ifposta = i;
    }

    public int getForbid_flag() {
        return this.forbid_flag;
    }

    public void setForbid_flag(int i) {
        this.forbid_flag = i;
    }

    public String getTbs() {
        return this.tbs;
    }

    public void setTbs(String str) {
        this.tbs = str;
    }

    public int getNeed_vcode() {
        return this.need_vcode;
    }

    public void setNeed_vcode(int i) {
        this.need_vcode = i;
    }

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public void setVcode_md5(String str) {
        this.vcode_md5 = str;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public void setVcode_pic_url(String str) {
        this.vcode_pic_url = str;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("AntiData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ifpost = jSONObject.optInt("ifpost", 0);
                this.ifposta = jSONObject.optInt("ifposta", 0);
                this.forbid_flag = jSONObject.optInt("forbid_flag", 0);
                this.tbs = jSONObject.optString("tbs");
                if (TiebaApplication.g() != null && this.tbs != null && this.tbs.length() > 0) {
                    TiebaApplication.g().m(this.tbs);
                }
                this.need_vcode = jSONObject.optInt("need_vcode", 0);
                this.vcode_md5 = jSONObject.optString("vcode_md5");
                this.vcode_pic_url = jSONObject.optString("vcode_pic_url");
                this.forbid_info = jSONObject.optString("forbid_info");
                this.ifvoice = jSONObject.optInt("ifvoice", 1);
                this.voice_message = jSONObject.optString("voice_message");
            } catch (Exception e) {
                com.baidu.tieba.util.av.b("AntiData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void logPrint() {
        com.baidu.tieba.util.av.d("AntiData", "logPrint", "ifpost = " + String.valueOf(this.ifpost));
        com.baidu.tieba.util.av.d("AntiData", "logPrint", "ifposta = " + String.valueOf(this.ifposta));
        com.baidu.tieba.util.av.d("AntiData", "logPrint", "forbid_flag = " + String.valueOf(this.forbid_flag));
        com.baidu.tieba.util.av.d("AntiData", "logPrint", "tbs = " + this.tbs);
        com.baidu.tieba.util.av.d("AntiData", "logPrint", "need_vcode = " + String.valueOf(this.need_vcode));
        com.baidu.tieba.util.av.d("AntiData", "logPrint", "vcode_md5 = " + this.vcode_md5);
    }

    public void setForbid_info(String str) {
        this.forbid_info = str;
    }

    public String getForbid_info() {
        return this.forbid_info;
    }
}
