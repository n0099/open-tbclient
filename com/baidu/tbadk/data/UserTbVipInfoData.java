package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.TbVipInfo;
/* loaded from: classes3.dex */
public class UserTbVipInfoData implements Serializable {
    public static final long serialVersionUID = 1112312312312L;
    public String vipIntro;
    public String vipV_detail;
    public String vipV_url;

    public String getvipIntro() {
        return this.vipIntro;
    }

    public String getvipV_detail() {
        return this.vipV_detail;
    }

    public String getvipV_url() {
        return this.vipV_url;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.vipIntro = jSONObject.optString("intro", "");
        this.vipV_url = jSONObject.optString("v_url", "");
        this.vipV_detail = jSONObject.optString("v_detail", "");
    }

    public void parserProtobuf(TbVipInfo tbVipInfo) {
        if (tbVipInfo == null) {
            return;
        }
        this.vipIntro = tbVipInfo.intro;
        this.vipV_url = tbVipInfo.v_url;
        this.vipV_detail = tbVipInfo.v_detail;
    }

    public void setVipIntro(String str) {
        this.vipIntro = str;
    }

    public void setVipV_detail(String str) {
        this.vipV_detail = str;
    }

    public void setVipV_url(String str) {
        this.vipV_url = str;
    }
}
