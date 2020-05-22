package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes3.dex */
public class j {
    private k fyy;
    private com.baidu.tieba.ala.guardclub.model.g fyz;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.fyy = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.fyz = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.fyy.setOtherParams(str2);
        this.fyy.setFeedId(str);
        this.fyz.k(this.fyy);
        this.fyy.a(this.fyz);
    }

    public void jY(boolean z) {
        this.fyy.jY(z);
    }

    public void yL() {
        if (this.fyy != null) {
            this.fyy.yL();
        }
    }

    public View getView() {
        return this.fyy.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCE() {
        if (this.fyz != null) {
            this.fyz.onDestory();
        }
        if (this.fyy != null) {
            this.fyy.buw();
        }
    }
}
