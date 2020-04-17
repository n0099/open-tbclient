package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes3.dex */
public class j {
    private k fkN;
    private com.baidu.tieba.ala.guardclub.model.g fkO;

    public j(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, g.a aVar) {
        this.fkN = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.fkO = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.fkN.setOtherParams(str);
        this.fkO.j(this.fkN);
        this.fkN.a(this.fkO);
    }

    public void jF(boolean z) {
        this.fkN.jF(z);
    }

    public void xy() {
        if (this.fkN != null) {
            this.fkN.xy();
        }
    }

    public View getView() {
        return this.fkN.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ayM() {
        if (this.fkO != null) {
            this.fkO.onDestory();
        }
        if (this.fkN != null) {
            this.fkN.boG();
        }
    }
}
