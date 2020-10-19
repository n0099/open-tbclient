package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes4.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d gqs;
    private e.a gqu = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId blA = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gqt = new com.baidu.tieba.ala.guardclub.model.e(this.blA, this.gqu);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gqs = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gqs.setOtherParams(str);
        this.gqt.a(this.gqs);
        this.gqs.f(this.gqt);
    }

    public View getView() {
        return this.gqs.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gqs != null) {
            this.gqs.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aTM() {
        if (this.gqt != null) {
            this.gqt.onDestory();
        }
        if (this.gqs != null) {
            this.gqs.bOa();
        }
    }
}
