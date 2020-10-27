package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes4.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d gAx;
    private e.a gAz = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId bnb = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gAy = new com.baidu.tieba.ala.guardclub.model.e(this.bnb, this.gAz);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gAx = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gAx.setOtherParams(str);
        this.gAy.a(this.gAx);
        this.gAx.f(this.gAy);
    }

    public View getView() {
        return this.gAx.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gAx != null) {
            this.gAx.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVG() {
        if (this.gAy != null) {
            this.gAy.onDestory();
        }
        if (this.gAx != null) {
            this.gAx.bQF();
        }
    }
}
