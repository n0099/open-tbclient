package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes3.dex */
public class j {
    private k eFI;
    private com.baidu.tieba.ala.guardclub.model.g eFJ;

    public j(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, g.a aVar) {
        this.eFI = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.eFJ = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.eFI.setOtherParams(str);
        this.eFJ.j(this.eFI);
        this.eFI.a(this.eFJ);
    }

    public void iC(boolean z) {
        this.eFI.iC(z);
    }

    public void ta() {
        if (this.eFI != null) {
            this.eFI.ta();
        }
    }

    public View getView() {
        return this.eFI.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqv() {
        if (this.eFJ != null) {
            this.eFJ.onDestory();
        }
        if (this.eFI != null) {
            this.eFI.bfh();
        }
    }
}
