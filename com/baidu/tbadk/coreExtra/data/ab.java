package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public boolean foP;
    public boolean foQ;
    public int foR;
    public int foS;
    public String foT;
    public String foU;
    public String foV;
    public int foW;
    public String foX;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.foP = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.foQ = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.foR = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.foS = jSONObject.optInt("downloadNaniShowRate", 2);
            this.foT = jSONObject.optString("downloadNaniLinkUrl", null);
            this.foU = jSONObject.optString("downloadNaniTxt", null);
            this.foV = jSONObject.optString("showNaniTailTxt", null);
            this.foW = jSONObject.optInt("showNaniTailVideoType", 0);
            this.foX = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
