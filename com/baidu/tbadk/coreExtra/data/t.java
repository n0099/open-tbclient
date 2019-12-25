package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    public boolean dif;
    public boolean dig;
    public int dih;
    public int dii;
    public String dij;
    public String dik;
    public String dil;
    public int dim;
    public String din;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dif = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.dig = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.dih = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.dii = jSONObject.optInt("downloadNaniShowRate", 2);
            this.dij = jSONObject.optString("downloadNaniLinkUrl", null);
            this.dik = jSONObject.optString("downloadNaniTxt", null);
            this.dil = jSONObject.optString("showNaniTailTxt", null);
            this.dim = jSONObject.optInt("showNaniTailVideoType", 0);
            this.din = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
