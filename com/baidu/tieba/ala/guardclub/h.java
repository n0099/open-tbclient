package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes4.dex */
public class h {
    private com.baidu.tieba.ala.guardclub.view.d gPb;
    private e.a gPd = new e.a() { // from class: com.baidu.tieba.ala.guardclub.h.1
    };
    private BdUniqueId brR = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gPc = new com.baidu.tieba.ala.guardclub.model.e(this.brR, this.gPd);

    public h(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gPb = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gPb.setOtherParams(str);
        this.gPc.a(this.gPb);
        this.gPb.f(this.gPc);
    }

    public View getView() {
        return this.gPb.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gPb != null) {
            this.gPb.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baD() {
        if (this.gPc != null) {
            this.gPc.onDestory();
        }
        if (this.gPb != null) {
            this.gPb.bWj();
        }
    }
}
