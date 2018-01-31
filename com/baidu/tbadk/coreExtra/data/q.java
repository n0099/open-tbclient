package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public boolean bgb;
    public boolean bgc;
    public int bgd;
    public int bge;
    public String bgf;
    public String bgg;
    public String bgh;
    public int bgi;
    public String bgj;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bgb = jSONObject.optInt("isShowDownloadNaniPanel", 1) == 1;
            this.bgc = jSONObject.optInt("isActivateNaniApp", 2) == 1;
            this.bgd = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.bge = jSONObject.optInt("downloadNaniShowRate", 2);
            this.bgf = jSONObject.optString("downloadNaniLinkUrl", null);
            this.bgg = jSONObject.optString("downloadNaniTxt", null);
            this.bgh = jSONObject.optString("showNaniTailTxt", null);
            this.bgi = jSONObject.optInt("showNaniTailVideoType", 0);
            this.bgj = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
