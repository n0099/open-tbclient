package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d eFQ;
    private e.a eFS = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId asc = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e eFR = new com.baidu.tieba.ala.guardclub.model.e(this.asc, this.eFS);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.eFQ = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.eFQ.setOtherParams(str);
        this.eFR.a(this.eFQ);
        this.eFQ.f(this.eFR);
    }

    public View getView() {
        return this.eFQ.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.eFQ != null) {
            this.eFQ.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqA() {
        if (this.eFR != null) {
            this.eFR.onDestory();
        }
        if (this.eFQ != null) {
            this.eFQ.bfp();
        }
    }
}
