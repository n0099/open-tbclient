package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public int aBA;
    public int aBB;
    public String aBC;
    public String aBD;
    public String aBE;
    public int aBF;
    public String aBG;
    public boolean aBy;
    public boolean aBz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBy = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.aBz = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.aBA = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aBB = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aBC = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aBD = jSONObject.optString("downloadNaniTxt", null);
            this.aBE = jSONObject.optString("showNaniTailTxt", null);
            this.aBF = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aBG = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
