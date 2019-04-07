package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean bXo;
    public boolean bXp;
    public int bXq;
    public int bXr;
    public String bXs;
    public String bXt;
    public String bXu;
    public int bXv;
    public String bXw;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bXo = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.bXp = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.bXq = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.bXr = jSONObject.optInt("downloadNaniShowRate", 2);
            this.bXs = jSONObject.optString("downloadNaniLinkUrl", null);
            this.bXt = jSONObject.optString("downloadNaniTxt", null);
            this.bXu = jSONObject.optString("showNaniTailTxt", null);
            this.bXv = jSONObject.optInt("showNaniTailVideoType", 0);
            this.bXw = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
