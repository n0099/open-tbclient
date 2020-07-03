package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes3.dex */
public class j {
    private k fJT;
    private com.baidu.tieba.ala.guardclub.model.g fJU;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.fJT = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.fJU = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.fJT.setOtherParams(str2);
        this.fJT.setFeedId(str);
        this.fJU.k(this.fJT);
        this.fJT.a(this.fJU);
    }

    public void km(boolean z) {
        this.fJT.km(z);
    }

    public void zl() {
        if (this.fJT != null) {
            this.fJT.zl();
        }
    }

    public View getView() {
        return this.fJT.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDK() {
        if (this.fJU != null) {
            this.fJU.onDestory();
        }
        if (this.fJT != null) {
            this.fJT.bxt();
        }
    }
}
