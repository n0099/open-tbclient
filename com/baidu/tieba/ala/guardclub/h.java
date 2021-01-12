package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes10.dex */
public class h {
    private com.baidu.tieba.ala.guardclub.view.d gWi;
    private e.a gWk = new e.a() { // from class: com.baidu.tieba.ala.guardclub.h.1
    };
    private BdUniqueId brL = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gWj = new com.baidu.tieba.ala.guardclub.model.e(this.brL, this.gWk);

    public h(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gWi = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gWi.setOtherParams(str);
        this.gWj.a(this.gWi);
        this.gWi.f(this.gWj);
    }

    public View getView() {
        return this.gWi.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gWi != null) {
            this.gWi.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.gWj != null) {
            this.gWj.onDestory();
        }
        if (this.gWi != null) {
            this.gWi.bUX();
        }
    }
}
