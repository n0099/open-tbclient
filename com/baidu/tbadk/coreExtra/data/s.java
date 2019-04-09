package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean bXp;
    public boolean bXq;
    public int bXr;
    public int bXs;
    public String bXt;
    public String bXu;
    public String bXv;
    public int bXw;
    public String bXx;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bXp = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.bXq = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.bXr = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.bXs = jSONObject.optInt("downloadNaniShowRate", 2);
            this.bXt = jSONObject.optString("downloadNaniLinkUrl", null);
            this.bXu = jSONObject.optString("downloadNaniTxt", null);
            this.bXv = jSONObject.optString("showNaniTailTxt", null);
            this.bXw = jSONObject.optInt("showNaniTailVideoType", 0);
            this.bXx = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
