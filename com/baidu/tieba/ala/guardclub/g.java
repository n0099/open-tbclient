package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d eFg;
    private e.a eFi = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId arR = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e eFh = new com.baidu.tieba.ala.guardclub.model.e(this.arR, this.eFi);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.eFg = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.eFg.setOtherParams(str);
        this.eFh.a(this.eFg);
        this.eFg.f(this.eFh);
    }

    public View getView() {
        return this.eFg.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.eFg != null) {
            this.eFg.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqv() {
        if (this.eFh != null) {
            this.eFh.onDestory();
        }
        if (this.eFg != null) {
            this.eFg.bfh();
        }
    }
}
