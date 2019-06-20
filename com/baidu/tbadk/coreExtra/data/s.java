package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean cfl;
    public boolean cfm;
    public int cfn;
    public int cfo;
    public String cfp;
    public String cfq;
    public String cfr;
    public int cfs;
    public String cft;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cfl = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.cfm = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.cfn = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.cfo = jSONObject.optInt("downloadNaniShowRate", 2);
            this.cfp = jSONObject.optString("downloadNaniLinkUrl", null);
            this.cfq = jSONObject.optString("downloadNaniTxt", null);
            this.cfr = jSONObject.optString("showNaniTailTxt", null);
            this.cfs = jSONObject.optInt("showNaniTailVideoType", 0);
            this.cft = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
