package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes7.dex */
public class j {
    private k gbr;
    private com.baidu.tieba.ala.guardclub.model.g gbs;

    public j(BaseActivity baseActivity, long j, long j2, long j3, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, BdUniqueId bdUniqueId, g.a aVar) {
        this.gbr = new k(baseActivity, j, j2, z, z2, z3, z4, bdUniqueId);
        this.gbs = new com.baidu.tieba.ala.guardclub.model.g(j3, z3, aVar);
        this.gbr.setOtherParams(str2);
        this.gbr.setFeedId(str);
        this.gbs.k(this.gbr);
        this.gbr.a(this.gbs);
    }

    public void ls(boolean z) {
        this.gbr.ls(z);
    }

    public void Fq() {
        if (this.gbr != null) {
            this.gbr.Fq();
        }
    }

    public View getView() {
        return this.gbr.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aQr() {
        if (this.gbs != null) {
            this.gbs.onDestory();
        }
        if (this.gbr != null) {
            this.gbr.bKg();
        }
    }
}
