package com.baidu.tbadk.k;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String KP;
    public long KQ;
    public boolean aTJ;
    public boolean isSuccess;

    public void KF() {
        o oVar;
        if (m.KK().KL() && (oVar = (o) m.KK().fo(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void KG() {
        o oVar;
        if (m.KK().KL() && (oVar = (o) m.KK().fo(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
