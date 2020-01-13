package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.h;
/* loaded from: classes2.dex */
public class e {
    private com.baidu.tieba.ala.guardclub.view.b eAS;
    private h.a eAU = new h.a() { // from class: com.baidu.tieba.ala.guardclub.e.1
    };
    private BdUniqueId aoz = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.h eAT = new com.baidu.tieba.ala.guardclub.model.h(this.aoz, this.eAU);

    public e(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.eAS = new com.baidu.tieba.ala.guardclub.view.b(baseActivity, bdUniqueId);
        this.eAS.setOtherParams(str);
        this.eAT.a(this.eAS);
        this.eAS.f(this.eAT);
    }

    public View getView() {
        return this.eAS.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.eAS != null) {
            this.eAS.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aoh() {
        if (this.eAT != null) {
            this.eAT.onDestory();
        }
        if (this.eAS != null) {
            this.eAS.bcS();
        }
    }
}
