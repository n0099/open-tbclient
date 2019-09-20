package com.baidu.tbadk.p;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String Md;
    public long Me;
    public boolean cAP;
    public boolean isSuccess;

    public void avC() {
        o oVar;
        if (m.avH().avI() && (oVar = (o) m.avH().kX(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void avD() {
        o oVar;
        if (m.avH().avI() && (oVar = (o) m.avH().kX(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
