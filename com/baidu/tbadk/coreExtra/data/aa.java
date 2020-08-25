package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aa {
    public boolean eAH;
    public boolean eAI;
    public int eAJ;
    public int eAK;
    public String eAL;
    public String eAM;
    public String eAN;
    public int eAO;
    public String eAP;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAH = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.eAI = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.eAJ = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.eAK = jSONObject.optInt("downloadNaniShowRate", 2);
            this.eAL = jSONObject.optString("downloadNaniLinkUrl", null);
            this.eAM = jSONObject.optString("downloadNaniTxt", null);
            this.eAN = jSONObject.optString("showNaniTailTxt", null);
            this.eAO = jSONObject.optInt("showNaniTailVideoType", 0);
            this.eAP = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
