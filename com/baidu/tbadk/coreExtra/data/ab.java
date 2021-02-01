package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public boolean fri;
    public boolean frj;
    public int frk;
    public int frl;
    public String frm;
    public String frn;
    public String fro;
    public int frp;
    public String frq;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fri = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.frj = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.frk = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.frl = jSONObject.optInt("downloadNaniShowRate", 2);
            this.frm = jSONObject.optString("downloadNaniLinkUrl", null);
            this.frn = jSONObject.optString("downloadNaniTxt", null);
            this.fro = jSONObject.optString("showNaniTailTxt", null);
            this.frp = jSONObject.optInt("showNaniTailVideoType", 0);
            this.frq = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
