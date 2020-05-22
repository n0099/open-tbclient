package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d fxW;
    private e.a fxY = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId aWV = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e fxX = new com.baidu.tieba.ala.guardclub.model.e(this.aWV, this.fxY);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.fxW = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.fxW.setOtherParams(str);
        this.fxX.a(this.fxW);
        this.fxW.f(this.fxX);
    }

    public View getView() {
        return this.fxW.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.fxW != null) {
            this.fxW.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCE() {
        if (this.fxX != null) {
            this.fxX.onDestory();
        }
        if (this.fxW != null) {
            this.fxW.buw();
        }
    }
}
