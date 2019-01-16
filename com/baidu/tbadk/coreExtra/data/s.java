package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean aOM;
    public boolean aON;
    public int aOO;
    public int aOP;
    public String aOQ;
    public String aOR;
    public String aOS;
    public int aOT;
    public String aOU;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOM = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.aON = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.aOO = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aOP = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aOQ = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aOR = jSONObject.optString("downloadNaniTxt", null);
            this.aOS = jSONObject.optString("showNaniTailTxt", null);
            this.aOT = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aOU = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
