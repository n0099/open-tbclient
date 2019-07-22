package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean cgq;
    public boolean cgr;
    public int cgs;
    public int cgt;
    public String cgu;
    public String cgv;
    public String cgw;
    public int cgx;
    public String cgy;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cgq = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.cgr = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.cgs = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.cgt = jSONObject.optInt("downloadNaniShowRate", 2);
            this.cgu = jSONObject.optString("downloadNaniLinkUrl", null);
            this.cgv = jSONObject.optString("downloadNaniTxt", null);
            this.cgw = jSONObject.optString("showNaniTailTxt", null);
            this.cgx = jSONObject.optInt("showNaniTailVideoType", 0);
            this.cgy = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
