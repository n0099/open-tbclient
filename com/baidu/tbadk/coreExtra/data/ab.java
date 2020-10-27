package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public int eXA;
    public String eXB;
    public boolean eXt;
    public boolean eXu;
    public int eXv;
    public int eXw;
    public String eXx;
    public String eXy;
    public String eXz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eXt = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.eXu = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.eXv = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.eXw = jSONObject.optInt("downloadNaniShowRate", 2);
            this.eXx = jSONObject.optString("downloadNaniLinkUrl", null);
            this.eXy = jSONObject.optString("downloadNaniTxt", null);
            this.eXz = jSONObject.optString("showNaniTailTxt", null);
            this.eXA = jSONObject.optInt("showNaniTailVideoType", 0);
            this.eXB = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
