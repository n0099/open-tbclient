package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes4.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d gFS;
    private e.a gFU = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId bmJ = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gFT = new com.baidu.tieba.ala.guardclub.model.e(this.bmJ, this.gFU);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gFS = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gFS.setOtherParams(str);
        this.gFT.a(this.gFS);
        this.gFS.f(this.gFT);
    }

    public View getView() {
        return this.gFS.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gFS != null) {
            this.gFS.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aXy() {
        if (this.gFT != null) {
            this.gFT.onDestory();
        }
        if (this.gFS != null) {
            this.gFS.bSy();
        }
    }
}
