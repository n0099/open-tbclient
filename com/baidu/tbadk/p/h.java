package com.baidu.tbadk.p;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String Md;
    public long Me;
    public boolean czM;
    public boolean isSuccess;

    public void avo() {
        o oVar;
        if (m.avt().avu() && (oVar = (o) m.avt().kT(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void avp() {
        o oVar;
        if (m.avt().avu() && (oVar = (o) m.avt().kT(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
