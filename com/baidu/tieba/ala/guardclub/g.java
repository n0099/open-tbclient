package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes7.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d gaP;
    private e.a gaR = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId beX = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gaQ = new com.baidu.tieba.ala.guardclub.model.e(this.beX, this.gaR);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gaP = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gaP.setOtherParams(str);
        this.gaQ.a(this.gaP);
        this.gaP.f(this.gaQ);
    }

    public View getView() {
        return this.gaP.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gaP != null) {
            this.gaP.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aQr() {
        if (this.gaQ != null) {
            this.gaQ.onDestory();
        }
        if (this.gaP != null) {
            this.gaP.bKg();
        }
    }
}
