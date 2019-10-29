package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    public boolean cvn;
    public boolean cvo;
    public int cvp;
    public int cvq;
    public String cvr;
    public String cvs;
    public String cvt;
    public int cvu;
    public String cvv;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cvn = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.cvo = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.cvp = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.cvq = jSONObject.optInt("downloadNaniShowRate", 2);
            this.cvr = jSONObject.optString("downloadNaniLinkUrl", null);
            this.cvs = jSONObject.optString("downloadNaniTxt", null);
            this.cvt = jSONObject.optString("showNaniTailTxt", null);
            this.cvu = jSONObject.optInt("showNaniTailVideoType", 0);
            this.cvv = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
