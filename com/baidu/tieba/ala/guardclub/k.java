package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes4.dex */
public class k {
    private l gPB;
    private com.baidu.tieba.ala.guardclub.model.g gPC;

    public k(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gPB = new l(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gPC = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gPB.setOtherParams(str2);
        this.gPB.setFeedId(str);
        this.gPC.k(this.gPB);
        this.gPB.a(this.gPC);
    }

    public void mN(boolean z) {
        this.gPB.mN(z);
    }

    public void IR() {
        if (this.gPB != null) {
            this.gPB.IR();
        }
    }

    public View getView() {
        return this.gPB.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baD() {
        if (this.gPC != null) {
            this.gPC.onDestory();
        }
        if (this.gPB != null) {
            this.gPB.bWj();
        }
    }
}
