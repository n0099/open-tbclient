package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    public boolean eAL;
    public boolean eAM;
    public int eAN;
    public int eAO;
    public String eAP;
    public String eAQ;
    public String eAR;
    public int eAS;
    public String eAT;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAL = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.eAM = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.eAN = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.eAO = jSONObject.optInt("downloadNaniShowRate", 2);
            this.eAP = jSONObject.optString("downloadNaniLinkUrl", null);
            this.eAQ = jSONObject.optString("downloadNaniTxt", null);
            this.eAR = jSONObject.optString("showNaniTailTxt", null);
            this.eAS = jSONObject.optInt("showNaniTailVideoType", 0);
            this.eAT = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
