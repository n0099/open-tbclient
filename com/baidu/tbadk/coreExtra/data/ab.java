package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public boolean fdj;
    public boolean fdk;
    public int fdl;
    public int fdm;
    public String fdn;
    public String fdo;
    public String fdp;
    public int fdq;
    public String fdr;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fdj = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.fdk = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.fdl = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.fdm = jSONObject.optInt("downloadNaniShowRate", 2);
            this.fdn = jSONObject.optString("downloadNaniLinkUrl", null);
            this.fdo = jSONObject.optString("downloadNaniTxt", null);
            this.fdp = jSONObject.optString("showNaniTailTxt", null);
            this.fdq = jSONObject.optInt("showNaniTailVideoType", 0);
            this.fdr = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
