package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes4.dex */
public class j {
    private k gAX;
    private com.baidu.tieba.ala.guardclub.model.g gAY;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gAX = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gAY = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gAX.setOtherParams(str2);
        this.gAX.setFeedId(str);
        this.gAY.k(this.gAX);
        this.gAX.a(this.gAY);
    }

    public void mi(boolean z) {
        this.gAX.mi(z);
    }

    public void Hi() {
        if (this.gAX != null) {
            this.gAX.Hi();
        }
    }

    public View getView() {
        return this.gAX.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVG() {
        if (this.gAY != null) {
            this.gAY.onDestory();
        }
        if (this.gAX != null) {
            this.gAX.bQF();
        }
    }
}
