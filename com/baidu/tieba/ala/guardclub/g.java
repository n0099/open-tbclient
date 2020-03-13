package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d eFu;
    private e.a eFw = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId arS = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e eFv = new com.baidu.tieba.ala.guardclub.model.e(this.arS, this.eFw);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.eFu = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.eFu.setOtherParams(str);
        this.eFv.a(this.eFu);
        this.eFu.f(this.eFv);
    }

    public View getView() {
        return this.eFu.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.eFu != null) {
            this.eFu.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqx() {
        if (this.eFv != null) {
            this.eFv.onDestory();
        }
        if (this.eFu != null) {
            this.eFu.bfk();
        }
    }
}
