package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public boolean fcr;
    public boolean fcs;
    public int fct;
    public int fcu;
    public String fcv;
    public String fcw;
    public String fcx;
    public int fcy;
    public String fcz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fcr = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.fcs = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.fct = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.fcu = jSONObject.optInt("downloadNaniShowRate", 2);
            this.fcv = jSONObject.optString("downloadNaniLinkUrl", null);
            this.fcw = jSONObject.optString("downloadNaniTxt", null);
            this.fcx = jSONObject.optString("showNaniTailTxt", null);
            this.fcy = jSONObject.optInt("showNaniTailVideoType", 0);
            this.fcz = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
