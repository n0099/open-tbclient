package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes10.dex */
public class k {
    private l hbp;
    private com.baidu.tieba.ala.guardclub.model.g hbq;

    public k(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.hbp = new l(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.hbq = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.hbp.setOtherParams(str2);
        this.hbp.setFeedId(str);
        this.hbq.k(this.hbp);
        this.hbp.a(this.hbq);
    }

    public void no(boolean z) {
        this.hbp.no(z);
    }

    public void FQ() {
        if (this.hbp != null) {
            this.hbp.FQ();
        }
    }

    public View getView() {
        return this.hbp.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.hbq != null) {
            this.hbq.onDestory();
        }
        if (this.hbp != null) {
            this.hbp.bVP();
        }
    }
}
