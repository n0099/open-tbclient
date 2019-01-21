package com.baidu.tbadk.l;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String NV;
    public long NW;
    public boolean bgB;
    public boolean isSuccess;

    public void Py() {
        o oVar;
        if (m.PD().PE() && (oVar = (o) m.PD().gm(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void Pz() {
        o oVar;
        if (m.PD().PE() && (oVar = (o) m.PD().gm(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
