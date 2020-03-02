package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    public int dmA;
    public int dmB;
    public String dmC;
    public String dmD;
    public String dmE;
    public int dmF;
    public String dmG;
    public boolean dmy;
    public boolean dmz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dmy = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.dmz = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.dmA = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.dmB = jSONObject.optInt("downloadNaniShowRate", 2);
            this.dmC = jSONObject.optString("downloadNaniLinkUrl", null);
            this.dmD = jSONObject.optString("downloadNaniTxt", null);
            this.dmE = jSONObject.optString("showNaniTailTxt", null);
            this.dmF = jSONObject.optInt("showNaniTailVideoType", 0);
            this.dmG = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
