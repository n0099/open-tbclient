package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    public boolean dMX;
    public boolean dMY;
    public int dMZ;
    public int dNa;
    public String dNb;
    public String dNc;
    public String dNd;
    public int dNe;
    public String dNf;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dMX = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.dMY = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.dMZ = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.dNa = jSONObject.optInt("downloadNaniShowRate", 2);
            this.dNb = jSONObject.optString("downloadNaniLinkUrl", null);
            this.dNc = jSONObject.optString("downloadNaniTxt", null);
            this.dNd = jSONObject.optString("showNaniTailTxt", null);
            this.dNe = jSONObject.optInt("showNaniTailVideoType", 0);
            this.dNf = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
