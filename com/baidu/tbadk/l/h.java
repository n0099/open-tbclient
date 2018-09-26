package com.baidu.tbadk.l;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String Nl;
    public long Nm;
    public boolean aWZ;
    public boolean isSuccess;

    public void LU() {
        o oVar;
        if (m.LZ().Ma() && (oVar = (o) m.LZ().fA(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void LV() {
        o oVar;
        if (m.LZ().Ma() && (oVar = (o) m.LZ().fA(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
