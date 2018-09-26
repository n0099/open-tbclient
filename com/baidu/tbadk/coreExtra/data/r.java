package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    public boolean aFq;
    public boolean aFr;
    public int aFs;
    public int aFt;
    public String aFu;
    public String aFv;
    public String aFw;
    public int aFx;
    public String aFy;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aFq = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.aFr = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.aFs = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aFt = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aFu = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aFv = jSONObject.optString("downloadNaniTxt", null);
            this.aFw = jSONObject.optString("showNaniTailTxt", null);
            this.aFx = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aFy = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
