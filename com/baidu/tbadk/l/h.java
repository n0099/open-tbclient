package com.baidu.tbadk.l;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String NK;
    public long NL;
    public boolean bfM;
    public boolean isSuccess;

    public void Pf() {
        o oVar;
        if (m.Pk().Pl() && (oVar = (o) m.Pk().gl(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void Pg() {
        o oVar;
        if (m.Pk().Pl() && (oVar = (o) m.Pk().gl(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
