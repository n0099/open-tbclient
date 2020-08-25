package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes7.dex */
public class j {
    private k gbn;
    private com.baidu.tieba.ala.guardclub.model.g gbo;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gbn = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gbo = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gbn.setOtherParams(str2);
        this.gbn.setFeedId(str);
        this.gbo.k(this.gbn);
        this.gbn.a(this.gbo);
    }

    public void lq(boolean z) {
        this.gbn.lq(z);
    }

    public void Fq() {
        if (this.gbn != null) {
            this.gbn.Fq();
        }
    }

    public View getView() {
        return this.gbn.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aQr() {
        if (this.gbo != null) {
            this.gbo.onDestory();
        }
        if (this.gbn != null) {
            this.gbn.bKf();
        }
    }
}
