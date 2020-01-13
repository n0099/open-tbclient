package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.l;
/* loaded from: classes2.dex */
public class h {
    private i eBu;
    private com.baidu.tieba.ala.guardclub.model.l eBv;

    public h(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, l.a aVar) {
        this.eBu = new i(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.eBv = new com.baidu.tieba.ala.guardclub.model.l(j3, z3, aVar);
        this.eBu.setOtherParams(str);
        this.eBv.j(this.eBu);
        this.eBu.a(this.eBv);
    }

    public void iv(boolean z) {
        this.eBu.iv(z);
    }

    public void rP() {
        if (this.eBu != null) {
            this.eBu.rP();
        }
    }

    public View getView() {
        return this.eBu.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aoh() {
        if (this.eBv != null) {
            this.eBv.onDestory();
        }
        if (this.eBu != null) {
            this.eBu.bcS();
        }
    }
}
