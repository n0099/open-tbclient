package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    public String chA;
    public boolean chs;
    public boolean cht;
    public int chu;
    public int chv;
    public String chw;
    public String chx;
    public String chy;
    public int chz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.chs = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.cht = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.chu = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.chv = jSONObject.optInt("downloadNaniShowRate", 2);
            this.chw = jSONObject.optString("downloadNaniLinkUrl", null);
            this.chx = jSONObject.optString("downloadNaniTxt", null);
            this.chy = jSONObject.optString("showNaniTailTxt", null);
            this.chz = jSONObject.optInt("showNaniTailVideoType", 0);
            this.chA = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
