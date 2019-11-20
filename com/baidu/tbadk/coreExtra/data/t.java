package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    public String cuA;
    public String cuB;
    public String cuC;
    public int cuD;
    public String cuE;
    public boolean cuw;
    public boolean cux;
    public int cuy;
    public int cuz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cuw = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.cux = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.cuy = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.cuz = jSONObject.optInt("downloadNaniShowRate", 2);
            this.cuA = jSONObject.optString("downloadNaniLinkUrl", null);
            this.cuB = jSONObject.optString("downloadNaniTxt", null);
            this.cuC = jSONObject.optString("showNaniTailTxt", null);
            this.cuD = jSONObject.optInt("showNaniTailVideoType", 0);
            this.cuE = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
