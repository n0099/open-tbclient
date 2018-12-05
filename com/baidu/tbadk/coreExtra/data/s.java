package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean aOi;
    public boolean aOj;
    public int aOk;
    public int aOl;
    public String aOm;
    public String aOn;
    public String aOo;
    public int aOp;
    public String aOq;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOi = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.aOj = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.aOk = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aOl = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aOm = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aOn = jSONObject.optString("downloadNaniTxt", null);
            this.aOo = jSONObject.optString("showNaniTailTxt", null);
            this.aOp = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aOq = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
