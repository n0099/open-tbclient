package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean aOk;
    public boolean aOl;
    public int aOm;
    public int aOn;
    public String aOo;
    public String aOp;
    public String aOq;
    public int aOr;
    public String aOs;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOk = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.aOl = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.aOm = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.aOn = jSONObject.optInt("downloadNaniShowRate", 2);
            this.aOo = jSONObject.optString("downloadNaniLinkUrl", null);
            this.aOp = jSONObject.optString("downloadNaniTxt", null);
            this.aOq = jSONObject.optString("showNaniTailTxt", null);
            this.aOr = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aOs = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
