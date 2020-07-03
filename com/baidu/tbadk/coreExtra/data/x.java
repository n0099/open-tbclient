package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    public boolean ejZ;
    public boolean eka;
    public int ekb;
    public int ekc;
    public String ekd;
    public String eke;
    public String ekf;
    public int ekg;
    public String ekh;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ejZ = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.eka = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.ekb = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.ekc = jSONObject.optInt("downloadNaniShowRate", 2);
            this.ekd = jSONObject.optString("downloadNaniLinkUrl", null);
            this.eke = jSONObject.optString("downloadNaniTxt", null);
            this.ekf = jSONObject.optString("showNaniTailTxt", null);
            this.ekg = jSONObject.optInt("showNaniTailVideoType", 0);
            this.ekh = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
