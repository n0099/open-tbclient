package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d fkq;
    private e.a fks = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId aQK = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e fkr = new com.baidu.tieba.ala.guardclub.model.e(this.aQK, this.fks);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.fkq = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.fkq.setOtherParams(str);
        this.fkr.a(this.fkq);
        this.fkq.f(this.fkr);
    }

    public View getView() {
        return this.fkq.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.fkq != null) {
            this.fkq.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ayM() {
        if (this.fkr != null) {
            this.fkr.onDestory();
        }
        if (this.fkq != null) {
            this.fkq.boE();
        }
    }
}
