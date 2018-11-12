package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean aKJ;
    public boolean aKK;
    public int aKL;
    public int aKM;
    public String aKN;
    public String aKO;
    public String aKP;
    public int aKQ;
    public String aKR;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKJ = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.aKK = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.aKL = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aKM = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aKN = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aKO = jSONObject.optString("downloadNaniTxt", null);
            this.aKP = jSONObject.optString("showNaniTailTxt", null);
            this.aKQ = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aKR = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
