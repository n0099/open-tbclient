package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean aON;
    public boolean aOO;
    public int aOP;
    public int aOQ;
    public String aOR;
    public String aOS;
    public String aOT;
    public int aOU;
    public String aOV;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aON = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.aOO = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.aOP = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aOQ = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aOR = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aOS = jSONObject.optString("downloadNaniTxt", null);
            this.aOT = jSONObject.optString("showNaniTailTxt", null);
            this.aOU = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aOV = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
