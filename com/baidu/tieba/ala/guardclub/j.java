package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes3.dex */
public class j {
    private k eFJ;
    private com.baidu.tieba.ala.guardclub.model.g eFK;

    public j(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, g.a aVar) {
        this.eFJ = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.eFK = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.eFJ.setOtherParams(str);
        this.eFK.j(this.eFJ);
        this.eFJ.a(this.eFK);
    }

    public void iC(boolean z) {
        this.eFJ.iC(z);
    }

    public void ta() {
        if (this.eFJ != null) {
            this.eFJ.ta();
        }
    }

    public View getView() {
        return this.eFJ.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqx() {
        if (this.eFK != null) {
            this.eFK.onDestory();
        }
        if (this.eFJ != null) {
            this.eFJ.bfj();
        }
    }
}
