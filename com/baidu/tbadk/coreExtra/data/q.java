package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public boolean bhI;
    public boolean bhJ;
    public int bhK;
    public int bhL;
    public String bhM;
    public String bhN;
    public String bhO;
    public int bhP;
    public String bhQ;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bhI = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.bhJ = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.bhK = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.bhL = jSONObject.optInt("downloadNaniShowRate", 2);
            this.bhM = jSONObject.optString("downloadNaniLinkUrl", null);
            this.bhN = jSONObject.optString("downloadNaniTxt", null);
            this.bhO = jSONObject.optString("showNaniTailTxt", null);
            this.bhP = jSONObject.optInt("showNaniTailVideoType", 0);
            this.bhQ = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
