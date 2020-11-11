package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes4.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d gGl;
    private e.a gGn = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId bou = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gGm = new com.baidu.tieba.ala.guardclub.model.e(this.bou, this.gGn);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gGl = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gGl.setOtherParams(str);
        this.gGm.a(this.gGl);
        this.gGl.f(this.gGm);
    }

    public View getView() {
        return this.gGl.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gGl != null) {
            this.gGl.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYg() {
        if (this.gGm != null) {
            this.gGm.onDestory();
        }
        if (this.gGl != null) {
            this.gGl.bTf();
        }
    }
}
