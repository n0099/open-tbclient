package com.baidu.tbadk.l;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String KL;
    public long KM;
    public boolean aTK;
    public boolean isSuccess;

    public void KA() {
        o oVar;
        if (m.KF().KG() && (oVar = (o) m.KF().fp(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void KB() {
        o oVar;
        if (m.KF().KG() && (oVar = (o) m.KF().fp(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
