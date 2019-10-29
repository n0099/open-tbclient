package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.l;
/* loaded from: classes6.dex */
public class h {
    private i dMO;
    private com.baidu.tieba.ala.guardclub.model.l dMP;

    public h(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, l.a aVar) {
        this.dMO = new i(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.dMP = new com.baidu.tieba.ala.guardclub.model.l(j3, z3, aVar);
        this.dMO.setOtherParams(str);
        this.dMP.j(this.dMO);
        this.dMO.a(this.dMP);
    }

    public void he(boolean z) {
        this.dMO.he(z);
    }

    public void pZ() {
        if (this.dMO != null) {
            this.dMO.pZ();
        }
    }

    public View getView() {
        return this.dMO.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aLq() {
        if (this.dMP != null) {
            this.dMP.onDestory();
        }
        if (this.dMO != null) {
            this.dMO.aLp();
        }
    }
}
