package com.baidu.tbadk.o;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String Og;
    public long Oh;
    public boolean cqm;
    public boolean isSuccess;

    public void apf() {
        o oVar;
        if (m.apl().apm() && (oVar = (o) m.apl().ka(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void apg() {
        o oVar;
        if (m.apl().apm() && (oVar = (o) m.apl().ka(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
