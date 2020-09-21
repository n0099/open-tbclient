package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes4.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d gec;
    private e.a gee = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId bhK = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e ged = new com.baidu.tieba.ala.guardclub.model.e(this.bhK, this.gee);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gec = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gec.setOtherParams(str);
        this.ged.a(this.gec);
        this.gec.f(this.ged);
    }

    public View getView() {
        return this.gec.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gec != null) {
            this.gec.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aRd() {
        if (this.ged != null) {
            this.ged.onDestory();
        }
        if (this.gec != null) {
            this.gec.bLq();
        }
    }
}
