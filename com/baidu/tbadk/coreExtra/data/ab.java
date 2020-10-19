package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public boolean eOX;
    public boolean eOY;
    public int eOZ;
    public int ePa;
    public String ePb;
    public String ePc;
    public String ePd;
    public int ePe;
    public String ePf;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eOX = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.eOY = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.eOZ = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.ePa = jSONObject.optInt("downloadNaniShowRate", 2);
            this.ePb = jSONObject.optString("downloadNaniLinkUrl", null);
            this.ePc = jSONObject.optString("downloadNaniTxt", null);
            this.ePd = jSONObject.optString("showNaniTailTxt", null);
            this.ePe = jSONObject.optInt("showNaniTailVideoType", 0);
            this.ePf = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
