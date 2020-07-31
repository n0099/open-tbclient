package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes4.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d fOM;
    private e.a fOO = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId aZB = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e fON = new com.baidu.tieba.ala.guardclub.model.e(this.aZB, this.fOO);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.fOM = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.fOM.setOtherParams(str);
        this.fON.a(this.fOM);
        this.fOM.f(this.fON);
    }

    public View getView() {
        return this.fOM.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.fOM != null) {
            this.fOM.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aHB() {
        if (this.fON != null) {
            this.fON.onDestory();
        }
        if (this.fOM != null) {
            this.fOM.bAK();
        }
    }
}
