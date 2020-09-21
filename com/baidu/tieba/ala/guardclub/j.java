package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes4.dex */
public class j {
    private k geE;
    private com.baidu.tieba.ala.guardclub.model.g geF;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.geE = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.geF = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.geE.setOtherParams(str2);
        this.geE.setFeedId(str);
        this.geF.k(this.geE);
        this.geE.a(this.geF);
    }

    public void lu(boolean z) {
        this.geE.lu(z);
    }

    public void FQ() {
        if (this.geE != null) {
            this.geE.FQ();
        }
    }

    public View getView() {
        return this.geE.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aRd() {
        if (this.geF != null) {
            this.geF.onDestory();
        }
        if (this.geE != null) {
            this.geE.bLq();
        }
    }
}
