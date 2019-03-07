package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean bXl;
    public boolean bXm;
    public int bXn;
    public int bXo;
    public String bXp;
    public String bXq;
    public String bXr;
    public int bXs;
    public String bXt;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bXl = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.bXm = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.bXn = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.bXo = jSONObject.optInt("downloadNaniShowRate", 2);
            this.bXp = jSONObject.optString("downloadNaniLinkUrl", null);
            this.bXq = jSONObject.optString("downloadNaniTxt", null);
            this.bXr = jSONObject.optString("showNaniTailTxt", null);
            this.bXs = jSONObject.optInt("showNaniTailVideoType", 0);
            this.bXt = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
