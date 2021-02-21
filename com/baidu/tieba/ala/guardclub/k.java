package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes11.dex */
public class k {
    private l gZG;
    private com.baidu.tieba.ala.guardclub.model.g gZH;

    public k(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gZG = new l(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gZH = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gZG.setOtherParams(str2);
        this.gZG.setFeedId(str);
        this.gZH.k(this.gZG);
        this.gZG.a(this.gZH);
    }

    public void no(boolean z) {
        this.gZG.no(z);
    }

    public void FN() {
        if (this.gZG != null) {
            this.gZG.FN();
        }
    }

    public View getView() {
        return this.gZG.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.gZH != null) {
            this.gZH.onDestory();
        }
        if (this.gZG != null) {
            this.gZG.bVJ();
        }
    }
}
