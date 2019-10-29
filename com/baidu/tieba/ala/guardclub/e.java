package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.h;
/* loaded from: classes6.dex */
public class e {
    private com.baidu.tieba.ala.guardclub.view.b dMm;
    private h.a dMo = new h.a() { // from class: com.baidu.tieba.ala.guardclub.e.1
    };
    private BdUniqueId agc = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.h dMn = new com.baidu.tieba.ala.guardclub.model.h(this.agc, this.dMo);

    public e(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.dMm = new com.baidu.tieba.ala.guardclub.view.b(baseActivity, bdUniqueId);
        this.dMm.setOtherParams(str);
        this.dMn.a(this.dMm);
        this.dMm.f(this.dMn);
    }

    public View getView() {
        return this.dMm.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.dMm != null) {
            this.dMm.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aLq() {
        if (this.dMn != null) {
            this.dMn.onDestory();
        }
        if (this.dMm != null) {
            this.dMm.aLp();
        }
    }
}
