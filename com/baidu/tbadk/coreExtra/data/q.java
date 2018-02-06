package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public boolean bhU;
    public boolean bhV;
    public int bhW;
    public int bhX;
    public String bhY;
    public String bhZ;
    public String bia;
    public int bib;
    public String bic;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bhU = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.bhV = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.bhW = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.bhX = jSONObject.optInt("downloadNaniShowRate", 2);
            this.bhY = jSONObject.optString("downloadNaniLinkUrl", null);
            this.bhZ = jSONObject.optString("downloadNaniTxt", null);
            this.bia = jSONObject.optString("showNaniTailTxt", null);
            this.bib = jSONObject.optInt("showNaniTailVideoType", 0);
            this.bic = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
