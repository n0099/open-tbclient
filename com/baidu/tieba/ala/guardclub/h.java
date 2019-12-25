package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.l;
/* loaded from: classes2.dex */
public class h {
    private i eAj;
    private com.baidu.tieba.ala.guardclub.model.l eAk;

    public h(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, l.a aVar) {
        this.eAj = new i(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.eAk = new com.baidu.tieba.ala.guardclub.model.l(j3, z3, aVar);
        this.eAj.setOtherParams(str);
        this.eAk.j(this.eAj);
        this.eAj.a(this.eAk);
    }

    public void il(boolean z) {
        this.eAj.il(z);
    }

    public void rC() {
        if (this.eAj != null) {
            this.eAj.rC();
        }
    }

    public View getView() {
        return this.eAj.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void anO() {
        if (this.eAk != null) {
            this.eAk.onDestory();
        }
        if (this.eAj != null) {
            this.eAj.bcx();
        }
    }
}
