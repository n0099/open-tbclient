package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    public int diA;
    public String diB;
    public boolean dit;
    public boolean diu;
    public int div;
    public int diw;
    public String dix;
    public String diy;
    public String diz;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dit = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.diu = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.div = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.diw = jSONObject.optInt("downloadNaniShowRate", 2);
            this.dix = jSONObject.optString("downloadNaniLinkUrl", null);
            this.diy = jSONObject.optString("downloadNaniTxt", null);
            this.diz = jSONObject.optString("showNaniTailTxt", null);
            this.diA = jSONObject.optInt("showNaniTailVideoType", 0);
            this.diB = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
