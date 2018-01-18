package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public boolean bfT;
    public boolean bfU;
    public int bfV;
    public int bfW;
    public String bfX;
    public String bfY;
    public String bfZ;
    public int bga;
    public String bgb;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bfT = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.bfU = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.bfV = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.bfW = jSONObject.optInt("downloadNaniShowRate", 2);
            this.bfX = jSONObject.optString("downloadNaniLinkUrl", null);
            this.bfY = jSONObject.optString("downloadNaniTxt", null);
            this.bfZ = jSONObject.optString("showNaniTailTxt", null);
            this.bga = jSONObject.optInt("showNaniTailVideoType", 0);
            this.bgb = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
