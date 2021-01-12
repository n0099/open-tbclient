package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes10.dex */
public class k {
    private l gWI;
    private com.baidu.tieba.ala.guardclub.model.g gWJ;

    public k(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gWI = new l(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gWJ = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gWI.setOtherParams(str2);
        this.gWI.setFeedId(str);
        this.gWJ.k(this.gWI);
        this.gWI.a(this.gWJ);
    }

    public void nj(boolean z) {
        this.gWI.nj(z);
    }

    public void Ex() {
        if (this.gWI != null) {
            this.gWI.Ex();
        }
    }

    public View getView() {
        return this.gWI.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.gWJ != null) {
            this.gWJ.onDestory();
        }
        if (this.gWI != null) {
            this.gWI.bUX();
        }
    }
}
