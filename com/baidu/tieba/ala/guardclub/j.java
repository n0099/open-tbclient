package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes3.dex */
public class j {
    private k fkS;
    private com.baidu.tieba.ala.guardclub.model.g fkT;

    public j(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, g.a aVar) {
        this.fkS = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.fkT = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.fkS.setOtherParams(str);
        this.fkT.j(this.fkS);
        this.fkS.a(this.fkT);
    }

    public void jF(boolean z) {
        this.fkS.jF(z);
    }

    public void xx() {
        if (this.fkS != null) {
            this.fkS.xx();
        }
    }

    public View getView() {
        return this.fkS.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ayM() {
        if (this.fkT != null) {
            this.fkT.onDestory();
        }
        if (this.fkS != null) {
            this.fkS.boE();
        }
    }
}
