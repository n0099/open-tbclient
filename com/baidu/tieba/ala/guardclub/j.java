package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes4.dex */
public class j {
    private k gGL;
    private com.baidu.tieba.ala.guardclub.model.g gGM;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gGL = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gGM = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gGL.setOtherParams(str2);
        this.gGL.setFeedId(str);
        this.gGM.k(this.gGL);
        this.gGL.a(this.gGM);
    }

    public void mr(boolean z) {
        this.gGL.mr(z);
    }

    public void HJ() {
        if (this.gGL != null) {
            this.gGL.HJ();
        }
    }

    public View getView() {
        return this.gGL.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYg() {
        if (this.gGM != null) {
            this.gGM.onDestory();
        }
        if (this.gGL != null) {
            this.gGL.bTf();
        }
    }
}
