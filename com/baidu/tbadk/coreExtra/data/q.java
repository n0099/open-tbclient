package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public boolean bhL;
    public boolean bhM;
    public int bhN;
    public int bhO;
    public String bhP;
    public String bhQ;
    public String bhR;
    public int bhS;
    public String bhT;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bhL = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.bhM = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.bhN = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.bhO = jSONObject.optInt("downloadNaniShowRate", 2);
            this.bhP = jSONObject.optString("downloadNaniLinkUrl", null);
            this.bhQ = jSONObject.optString("downloadNaniTxt", null);
            this.bhR = jSONObject.optString("showNaniTailTxt", null);
            this.bhS = jSONObject.optInt("showNaniTailVideoType", 0);
            this.bhT = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
