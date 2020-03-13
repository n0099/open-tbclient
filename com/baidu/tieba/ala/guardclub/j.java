package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes3.dex */
public class j {
    private k eFW;
    private com.baidu.tieba.ala.guardclub.model.g eFX;

    public j(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, g.a aVar) {
        this.eFW = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.eFX = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.eFW.setOtherParams(str);
        this.eFX.j(this.eFW);
        this.eFW.a(this.eFX);
    }

    public void iC(boolean z) {
        this.eFW.iC(z);
    }

    public void ta() {
        if (this.eFW != null) {
            this.eFW.ta();
        }
    }

    public View getView() {
        return this.eFW.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqx() {
        if (this.eFX != null) {
            this.eFX.onDestory();
        }
        if (this.eFW != null) {
            this.eFW.bfk();
        }
    }
}
