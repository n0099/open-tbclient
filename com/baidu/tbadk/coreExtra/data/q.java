package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public String aCA;
    public boolean aCs;
    public boolean aCt;
    public int aCu;
    public int aCv;
    public String aCw;
    public String aCx;
    public String aCy;
    public int aCz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCs = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.aCt = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.aCu = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aCv = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aCw = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aCx = jSONObject.optString("downloadNaniTxt", null);
            this.aCy = jSONObject.optString("showNaniTailTxt", null);
            this.aCz = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aCA = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
