package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    public boolean dMT;
    public boolean dMU;
    public int dMV;
    public int dMW;
    public String dMX;
    public String dMY;
    public String dMZ;
    public int dNa;
    public String dNb;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dMT = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.dMU = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.dMV = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.dMW = jSONObject.optInt("downloadNaniShowRate", 2);
            this.dMX = jSONObject.optString("downloadNaniLinkUrl", null);
            this.dMY = jSONObject.optString("downloadNaniTxt", null);
            this.dMZ = jSONObject.optString("showNaniTailTxt", null);
            this.dNa = jSONObject.optInt("showNaniTailVideoType", 0);
            this.dNb = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
