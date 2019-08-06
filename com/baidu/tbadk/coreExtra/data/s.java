package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public int cgA;
    public String cgB;
    public String cgC;
    public String cgD;
    public int cgE;
    public String cgF;
    public boolean cgx;
    public boolean cgy;
    public int cgz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cgx = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.cgy = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.cgz = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.cgA = jSONObject.optInt("downloadNaniShowRate", 2);
            this.cgB = jSONObject.optString("downloadNaniLinkUrl", null);
            this.cgC = jSONObject.optString("downloadNaniTxt", null);
            this.cgD = jSONObject.optString("showNaniTailTxt", null);
            this.cgE = jSONObject.optInt("showNaniTailVideoType", 0);
            this.cgF = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
