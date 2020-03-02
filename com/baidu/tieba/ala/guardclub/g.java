package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d eFh;
    private e.a eFj = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId arR = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e eFi = new com.baidu.tieba.ala.guardclub.model.e(this.arR, this.eFj);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.eFh = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.eFh.setOtherParams(str);
        this.eFi.a(this.eFh);
        this.eFh.f(this.eFi);
    }

    public View getView() {
        return this.eFh.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.eFh != null) {
            this.eFh.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqx() {
        if (this.eFi != null) {
            this.eFi.onDestory();
        }
        if (this.eFh != null) {
            this.eFh.bfj();
        }
    }
}
