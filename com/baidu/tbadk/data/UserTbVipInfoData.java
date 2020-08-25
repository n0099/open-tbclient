package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.TbVipInfo;
/* loaded from: classes2.dex */
public class UserTbVipInfoData implements Serializable {
    private static final long serialVersionUID = 1112312312312L;
    private String vipIntro;
    private String vipV_detail;
    private String vipV_url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.vipIntro = jSONObject.optString("intro", "");
            this.vipV_url = jSONObject.optString("v_url", "");
            this.vipV_detail = jSONObject.optString("v_detail", "");
        }
    }

    public void parserProtobuf(TbVipInfo tbVipInfo) {
        if (tbVipInfo != null) {
            this.vipIntro = tbVipInfo.intro;
            this.vipV_url = tbVipInfo.v_url;
            this.vipV_detail = tbVipInfo.v_detail;
        }
    }

    public String getvipIntro() {
        return this.vipIntro;
    }

    public String getvipV_url() {
        return this.vipV_url;
    }

    public String getvipV_detail() {
        return this.vipV_detail;
    }

    public void setVipIntro(String str) {
        this.vipIntro = str;
    }

    public void setVipV_url(String str) {
        this.vipV_url = str;
    }

    public void setVipV_detail(String str) {
        this.vipV_detail = str;
    }
}
