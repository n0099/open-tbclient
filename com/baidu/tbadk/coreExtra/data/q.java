package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public boolean aCn;
    public boolean aCo;
    public int aCp;
    public int aCq;
    public String aCr;
    public String aCs;
    public String aCt;
    public int aCu;
    public String aCv;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCn = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.aCo = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.aCp = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aCq = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aCr = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aCs = jSONObject.optString("downloadNaniTxt", null);
            this.aCt = jSONObject.optString("showNaniTailTxt", null);
            this.aCu = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aCv = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
