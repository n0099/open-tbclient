package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    public boolean ebo;
    public boolean ebp;
    public int ebq;
    public int ebr;
    public String ebs;
    public String ebt;
    public String ebu;
    public int ebv;
    public String ebw;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ebo = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.ebp = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.ebq = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.ebr = jSONObject.optInt("downloadNaniShowRate", 2);
            this.ebs = jSONObject.optString("downloadNaniLinkUrl", null);
            this.ebt = jSONObject.optString("downloadNaniTxt", null);
            this.ebu = jSONObject.optString("showNaniTailTxt", null);
            this.ebv = jSONObject.optInt("showNaniTailVideoType", 0);
            this.ebw = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
