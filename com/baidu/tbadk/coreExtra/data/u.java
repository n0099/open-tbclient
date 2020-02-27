package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    public int dmA;
    public String dmB;
    public String dmC;
    public String dmD;
    public int dmE;
    public String dmF;
    public boolean dmx;
    public boolean dmy;
    public int dmz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dmx = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.dmy = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.dmz = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.dmA = jSONObject.optInt("downloadNaniShowRate", 2);
            this.dmB = jSONObject.optString("downloadNaniLinkUrl", null);
            this.dmC = jSONObject.optString("downloadNaniTxt", null);
            this.dmD = jSONObject.optString("showNaniTailTxt", null);
            this.dmE = jSONObject.optInt("showNaniTailVideoType", 0);
            this.dmF = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
