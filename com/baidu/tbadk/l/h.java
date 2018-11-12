package com.baidu.tbadk.l;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String NK;
    public long NL;
    public boolean bcm;
    public boolean isSuccess;

    public void Ob() {
        o oVar;
        if (m.Og().Oh() && (oVar = (o) m.Og().fX(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void Oc() {
        o oVar;
        if (m.Og().Oh() && (oVar = (o) m.Og().fX(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
