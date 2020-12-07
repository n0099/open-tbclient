package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes4.dex */
public class k {
    private com.baidu.tieba.ala.guardclub.model.g gPA;
    private l gPz;

    public k(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gPz = new l(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gPA = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gPz.setOtherParams(str2);
        this.gPz.setFeedId(str);
        this.gPA.k(this.gPz);
        this.gPz.a(this.gPA);
    }

    public void mN(boolean z) {
        this.gPz.mN(z);
    }

    public void IR() {
        if (this.gPz != null) {
            this.gPz.IR();
        }
    }

    public View getView() {
        return this.gPz.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baD() {
        if (this.gPA != null) {
            this.gPA.onDestory();
        }
        if (this.gPz != null) {
            this.gPz.bWi();
        }
    }
}
