package com.baidu.tbadk.p;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String Md;
    public long Me;
    public boolean czT;
    public boolean isSuccess;

    public void avq() {
        o oVar;
        if (m.avv().avw() && (oVar = (o) m.avv().kU(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void avr() {
        o oVar;
        if (m.avv().avw() && (oVar = (o) m.avv().kU(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
