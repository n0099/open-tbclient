package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    public boolean eCQ;
    public boolean eCR;
    public int eCS;
    public int eCT;
    public String eCU;
    public String eCV;
    public String eCW;
    public int eCX;
    public String eCY;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eCQ = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.eCR = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.eCS = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.eCT = jSONObject.optInt("downloadNaniShowRate", 2);
            this.eCU = jSONObject.optString("downloadNaniLinkUrl", null);
            this.eCV = jSONObject.optString("downloadNaniTxt", null);
            this.eCW = jSONObject.optString("showNaniTailTxt", null);
            this.eCX = jSONObject.optInt("showNaniTailVideoType", 0);
            this.eCY = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
