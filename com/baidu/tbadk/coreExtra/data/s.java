package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    public boolean bXm;
    public boolean bXn;
    public int bXo;
    public int bXp;
    public String bXq;
    public String bXr;
    public String bXs;
    public int bXt;
    public String bXu;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bXm = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.bXn = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.bXo = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.bXp = jSONObject.optInt("downloadNaniShowRate", 2);
            this.bXq = jSONObject.optString("downloadNaniLinkUrl", null);
            this.bXr = jSONObject.optString("downloadNaniTxt", null);
            this.bXs = jSONObject.optString("showNaniTailTxt", null);
            this.bXt = jSONObject.optInt("showNaniTailVideoType", 0);
            this.bXu = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
