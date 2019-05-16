package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean cfk;
    public boolean cfl;
    public int cfm;
    public int cfn;
    public String cfo;
    public String cfp;
    public String cfq;
    public int cfr;
    public String cfs;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cfk = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.cfl = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.cfm = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.cfn = jSONObject.optInt("downloadNaniShowRate", 2);
            this.cfo = jSONObject.optString("downloadNaniLinkUrl", null);
            this.cfp = jSONObject.optString("downloadNaniTxt", null);
            this.cfq = jSONObject.optString("showNaniTailTxt", null);
            this.cfr = jSONObject.optInt("showNaniTailVideoType", 0);
            this.cfs = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
