package com.baidu.tbadk.l;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String NH;
    public long NI;
    public boolean bbz;
    public boolean isSuccess;

    public void NS() {
        o oVar;
        if (m.NX().NY() && (oVar = (o) m.NX().fJ(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void NT() {
        o oVar;
        if (m.NX().NY() && (oVar = (o) m.NX().fJ(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
