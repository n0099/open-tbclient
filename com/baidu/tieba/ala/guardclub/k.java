package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes11.dex */
public class k {
    private l gZs;
    private com.baidu.tieba.ala.guardclub.model.g gZt;

    public k(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gZs = new l(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gZt = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gZs.setOtherParams(str2);
        this.gZs.setFeedId(str);
        this.gZt.k(this.gZs);
        this.gZs.a(this.gZt);
    }

    public void no(boolean z) {
        this.gZs.no(z);
    }

    public void FN() {
        if (this.gZs != null) {
            this.gZs.FN();
        }
    }

    public View getView() {
        return this.gZs.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.gZt != null) {
            this.gZt.onDestory();
        }
        if (this.gZs != null) {
            this.gZs.bVC();
        }
    }
}
