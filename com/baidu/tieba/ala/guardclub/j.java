package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes3.dex */
public class j {
    private k fyJ;
    private com.baidu.tieba.ala.guardclub.model.g fyK;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.fyJ = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.fyK = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.fyJ.setOtherParams(str2);
        this.fyJ.setFeedId(str);
        this.fyK.k(this.fyJ);
        this.fyJ.a(this.fyK);
    }

    public void jY(boolean z) {
        this.fyJ.jY(z);
    }

    public void yL() {
        if (this.fyJ != null) {
            this.fyJ.yL();
        }
    }

    public View getView() {
        return this.fyJ.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCE() {
        if (this.fyK != null) {
            this.fyK.onDestory();
        }
        if (this.fyJ != null) {
            this.fyJ.buy();
        }
    }
}
