package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    public boolean aJT;
    public boolean aJU;
    public int aJV;
    public int aJW;
    public String aJX;
    public String aJY;
    public String aJZ;
    public int aKa;
    public String aKb;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJT = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.aJU = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.aJV = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aJW = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aJX = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aJY = jSONObject.optString("downloadNaniTxt", null);
            this.aJZ = jSONObject.optString("showNaniTailTxt", null);
            this.aKa = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aKb = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
