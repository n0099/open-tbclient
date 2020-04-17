package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d fkl;
    private e.a fkn = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId aQF = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e fkm = new com.baidu.tieba.ala.guardclub.model.e(this.aQF, this.fkn);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.fkl = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.fkl.setOtherParams(str);
        this.fkm.a(this.fkl);
        this.fkl.f(this.fkm);
    }

    public View getView() {
        return this.fkl.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.fkl != null) {
            this.fkl.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ayM() {
        if (this.fkm != null) {
            this.fkm.onDestory();
        }
        if (this.fkl != null) {
            this.fkl.boG();
        }
    }
}
