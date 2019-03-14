package com.baidu.tbadk.o;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String Oh;
    public long Oi;
    public boolean cqm;
    public boolean isSuccess;

    public void ape() {
        o oVar;
        if (m.apk().apl() && (oVar = (o) m.apk().ka(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void apf() {
        o oVar;
        if (m.apk().apl() && (oVar = (o) m.apk().ka(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
