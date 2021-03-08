package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes10.dex */
public class h {
    private com.baidu.tieba.ala.guardclub.view.d haP;
    private e.a haR = new e.a() { // from class: com.baidu.tieba.ala.guardclub.h.1
    };
    private BdUniqueId aEw = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e haQ = new com.baidu.tieba.ala.guardclub.model.e(this.aEw, this.haR);

    public h(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.haP = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.haP.setOtherParams(str);
        this.haQ.a(this.haP);
        this.haP.f(this.haQ);
    }

    public View getView() {
        return this.haP.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.haP != null) {
            this.haP.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.haQ != null) {
            this.haQ.onDestory();
        }
        if (this.haP != null) {
            this.haP.bVP();
        }
    }
}
