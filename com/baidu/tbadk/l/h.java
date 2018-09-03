package com.baidu.tbadk.l;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String KL;
    public long KM;
    public boolean aTK;
    public boolean isSuccess;

    public void KE() {
        o oVar;
        if (m.KJ().KK() && (oVar = (o) m.KJ().fo(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void KF() {
        o oVar;
        if (m.KJ().KK() && (oVar = (o) m.KJ().fo(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
