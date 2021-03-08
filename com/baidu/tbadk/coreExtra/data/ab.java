package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public boolean fsI;
    public boolean fsJ;
    public int fsK;
    public int fsL;
    public String fsM;
    public String fsN;
    public String fsO;
    public int fsP;
    public String fsQ;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fsI = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.fsJ = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.fsK = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.fsL = jSONObject.optInt("downloadNaniShowRate", 2);
            this.fsM = jSONObject.optString("downloadNaniLinkUrl", null);
            this.fsN = jSONObject.optString("downloadNaniTxt", null);
            this.fsO = jSONObject.optString("showNaniTailTxt", null);
            this.fsP = jSONObject.optInt("showNaniTailVideoType", 0);
            this.fsQ = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
