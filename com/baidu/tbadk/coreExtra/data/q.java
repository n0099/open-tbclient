package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public boolean aCk;
    public boolean aCl;
    public int aCm;
    public int aCn;
    public String aCo;
    public String aCp;
    public String aCq;
    public int aCr;
    public String aCs;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCk = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.aCl = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.aCm = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aCn = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aCo = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aCp = jSONObject.optString("downloadNaniTxt", null);
            this.aCq = jSONObject.optString("showNaniTailTxt", null);
            this.aCr = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aCs = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
