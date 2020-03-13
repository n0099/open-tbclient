package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    public boolean dmL;
    public boolean dmM;
    public int dmN;
    public int dmO;
    public String dmP;
    public String dmQ;
    public String dmR;
    public int dmS;
    public String dmT;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dmL = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.dmM = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.dmN = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.dmO = jSONObject.optInt("downloadNaniShowRate", 2);
            this.dmP = jSONObject.optString("downloadNaniLinkUrl", null);
            this.dmQ = jSONObject.optString("downloadNaniTxt", null);
            this.dmR = jSONObject.optString("showNaniTailTxt", null);
            this.dmS = jSONObject.optInt("showNaniTailVideoType", 0);
            this.dmT = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
