package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.l;
/* loaded from: classes6.dex */
public class h {
    private i dLX;
    private com.baidu.tieba.ala.guardclub.model.l dLY;

    public h(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, l.a aVar) {
        this.dLX = new i(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.dLY = new com.baidu.tieba.ala.guardclub.model.l(j3, z3, aVar);
        this.dLX.setOtherParams(str);
        this.dLY.j(this.dLX);
        this.dLX.a(this.dLY);
    }

    public void he(boolean z) {
        this.dLX.he(z);
    }

    public void qa() {
        if (this.dLX != null) {
            this.dLX.qa();
        }
    }

    public View getView() {
        return this.dLX.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aLo() {
        if (this.dLY != null) {
            this.dLY.onDestory();
        }
        if (this.dLX != null) {
            this.dLX.aLn();
        }
    }
}
