package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes11.dex */
public class k {
    private l hbo;
    private com.baidu.tieba.ala.guardclub.model.g hbp;

    public k(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.hbo = new l(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.hbp = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.hbo.setOtherParams(str2);
        this.hbo.setFeedId(str);
        this.hbp.k(this.hbo);
        this.hbo.a(this.hbp);
    }

    public void nn(boolean z) {
        this.hbo.nn(z);
    }

    public void Is() {
        if (this.hbo != null) {
            this.hbo.Is();
        }
    }

    public View getView() {
        return this.hbo.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.hbp != null) {
            this.hbp.onDestory();
        }
        if (this.hbo != null) {
            this.hbo.bYO();
        }
    }
}
