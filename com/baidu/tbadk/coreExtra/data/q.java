package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public boolean atr;
    public boolean ats;
    public int att;
    public int atu;
    public String atv;
    public String atw;
    public String atx;
    public int aty;
    public String atz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.atr = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.ats = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.att = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.atu = jSONObject.optInt("downloadNaniShowRate", 2);
            this.atv = jSONObject.optString("downloadNaniLinkUrl", null);
            this.atw = jSONObject.optString("downloadNaniTxt", null);
            this.atx = jSONObject.optString("showNaniTailTxt", null);
            this.aty = jSONObject.optInt("showNaniTailVideoType", 0);
            this.atz = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
