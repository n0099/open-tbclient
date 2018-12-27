package com.baidu.tbadk.l;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String NK;
    public long NL;
    public boolean bfP;
    public boolean isSuccess;

    public void Pg() {
        o oVar;
        if (m.Pl().Pm() && (oVar = (o) m.Pl().gm(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void Ph() {
        o oVar;
        if (m.Pl().Pm() && (oVar = (o) m.Pl().gm(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
