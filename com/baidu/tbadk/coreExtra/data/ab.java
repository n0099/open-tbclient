package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public boolean fjQ;
    public boolean fjR;
    public int fjS;
    public int fjT;
    public String fjU;
    public String fjV;
    public String fjW;
    public int fjX;
    public String fjY;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fjQ = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.fjR = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.fjS = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.fjT = jSONObject.optInt("downloadNaniShowRate", 2);
            this.fjU = jSONObject.optString("downloadNaniLinkUrl", null);
            this.fjV = jSONObject.optString("downloadNaniTxt", null);
            this.fjW = jSONObject.optString("showNaniTailTxt", null);
            this.fjX = jSONObject.optInt("showNaniTailVideoType", 0);
            this.fjY = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
