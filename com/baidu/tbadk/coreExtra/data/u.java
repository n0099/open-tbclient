package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    public boolean dmY;
    public boolean dmZ;
    public int dna;
    public int dnb;
    public String dnc;
    public String dnd;
    public String dne;
    public int dnf;
    public String dng;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dmY = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.dmZ = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.dna = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.dnb = jSONObject.optInt("downloadNaniShowRate", 2);
            this.dnc = jSONObject.optString("downloadNaniLinkUrl", null);
            this.dnd = jSONObject.optString("downloadNaniTxt", null);
            this.dne = jSONObject.optString("showNaniTailTxt", null);
            this.dnf = jSONObject.optInt("showNaniTailVideoType", 0);
            this.dng = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
