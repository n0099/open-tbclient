package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes3.dex */
public class j {
    private k eGs;
    private com.baidu.tieba.ala.guardclub.model.g eGt;

    public j(BaseActivity baseActivity, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, BdUniqueId bdUniqueId, g.a aVar) {
        this.eGs = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.eGt = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.eGs.setOtherParams(str);
        this.eGt.j(this.eGs);
        this.eGs.a(this.eGt);
    }

    public void iE(boolean z) {
        this.eGs.iE(z);
    }

    public void tf() {
        if (this.eGs != null) {
            this.eGs.tf();
        }
    }

    public View getView() {
        return this.eGs.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqA() {
        if (this.eGt != null) {
            this.eGt.onDestory();
        }
        if (this.eGs != null) {
            this.eGs.bfp();
        }
    }
}
