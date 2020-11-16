package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes4.dex */
public class j {
    private k gGs;
    private com.baidu.tieba.ala.guardclub.model.g gGt;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gGs = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gGt = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gGs.setOtherParams(str2);
        this.gGs.setFeedId(str);
        this.gGt.k(this.gGs);
        this.gGs.a(this.gGt);
    }

    public void ms(boolean z) {
        this.gGs.ms(z);
    }

    public void Ha() {
        if (this.gGs != null) {
            this.gGs.Ha();
        }
    }

    public View getView() {
        return this.gGs.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aXy() {
        if (this.gGt != null) {
            this.gGt.onDestory();
        }
        if (this.gGs != null) {
            this.gGs.bSy();
        }
    }
}
