package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public boolean ftB;
    public boolean ftC;
    public int ftD;
    public int ftE;
    public String ftF;
    public String ftG;
    public String ftH;
    public int ftI;
    public String ftJ;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ftB = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.ftC = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.ftD = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.ftE = jSONObject.optInt("downloadNaniShowRate", 2);
            this.ftF = jSONObject.optString("downloadNaniLinkUrl", null);
            this.ftG = jSONObject.optString("downloadNaniTxt", null);
            this.ftH = jSONObject.optString("showNaniTailTxt", null);
            this.ftI = jSONObject.optInt("showNaniTailVideoType", 0);
            this.ftJ = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
