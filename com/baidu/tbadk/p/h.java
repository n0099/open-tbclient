package com.baidu.tbadk.p;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String LQ;
    public long LR;
    public boolean cyv;
    public boolean isSuccess;

    public void auf() {
        o oVar;
        if (m.auk().aul() && (oVar = (o) m.auk().kN(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void aug() {
        o oVar;
        if (m.auk().aul() && (oVar = (o) m.auk().kN(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
