package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes7.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d gaL;
    private e.a gaN = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId beV = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gaM = new com.baidu.tieba.ala.guardclub.model.e(this.beV, this.gaN);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gaL = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gaL.setOtherParams(str);
        this.gaM.a(this.gaL);
        this.gaL.f(this.gaM);
    }

    public View getView() {
        return this.gaL.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gaL != null) {
            this.gaL.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aQr() {
        if (this.gaM != null) {
            this.gaM.onDestory();
        }
        if (this.gaL != null) {
            this.gaL.bKf();
        }
    }
}
