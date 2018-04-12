package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public boolean atq;
    public boolean atr;
    public int ats;
    public int att;
    public String atu;
    public String atv;
    public String atw;
    public int atx;
    public String aty;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.atq = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.atr = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.ats = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.att = jSONObject.optInt("downloadNaniShowRate", 2);
            this.atu = jSONObject.optString("downloadNaniLinkUrl", null);
            this.atv = jSONObject.optString("downloadNaniTxt", null);
            this.atw = jSONObject.optString("showNaniTailTxt", null);
            this.atx = jSONObject.optInt("showNaniTailVideoType", 0);
            this.aty = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
