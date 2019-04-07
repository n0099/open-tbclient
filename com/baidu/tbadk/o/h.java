package com.baidu.tbadk.o;

import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class h extends g {
    public String Oh;
    public long Oi;
    public boolean cqo;
    public boolean isSuccess;

    public void apb() {
        o oVar;
        if (m.apg().aph() && (oVar = (o) m.apg().jZ(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void apc() {
        o oVar;
        if (m.apg().aph() && (oVar = (o) m.apg().jZ(this.mSubType)) != null) {
            oVar.a(this, SocialConstants.PARAM_IMG_URL);
        }
    }
}
