package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    public boolean eqn;
    public boolean eqo;
    public int eqp;
    public int eqq;
    public String eqr;
    public String eqs;
    public String eqt;
    public int equ;
    public String eqv;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eqn = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
            this.eqo = jSONObject.optInt("isActivateNaniApp", 1) == 1;
            this.eqp = jSONObject.optInt("downloadNaniShowPosition", 3);
            this.eqq = jSONObject.optInt("downloadNaniShowRate", 2);
            this.eqr = jSONObject.optString("downloadNaniLinkUrl", null);
            this.eqs = jSONObject.optString("downloadNaniTxt", null);
            this.eqt = jSONObject.optString("showNaniTailTxt", null);
            this.equ = jSONObject.optInt("showNaniTailVideoType", 0);
            this.eqv = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
        }
    }
}
