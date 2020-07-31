package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes4.dex */
public class j {
    private k fPo;
    private com.baidu.tieba.ala.guardclub.model.g fPp;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.fPo = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.fPp = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.fPo.setOtherParams(str2);
        this.fPo.setFeedId(str);
        this.fPp.k(this.fPo);
        this.fPo.a(this.fPp);
    }

    public void kQ(boolean z) {
        this.fPo.kQ(z);
    }

    public void zN() {
        if (this.fPo != null) {
            this.fPo.zN();
        }
    }

    public View getView() {
        return this.fPo.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aHB() {
        if (this.fPp != null) {
            this.fPp.onDestory();
        }
        if (this.fPo != null) {
            this.fPo.bAK();
        }
    }
}
