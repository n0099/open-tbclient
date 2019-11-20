package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.h;
/* loaded from: classes6.dex */
public class e {
    private com.baidu.tieba.ala.guardclub.view.b dLv;
    private h.a dLx = new h.a() { // from class: com.baidu.tieba.ala.guardclub.e.1
    };
    private BdUniqueId afK = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.h dLw = new com.baidu.tieba.ala.guardclub.model.h(this.afK, this.dLx);

    public e(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.dLv = new com.baidu.tieba.ala.guardclub.view.b(baseActivity, bdUniqueId);
        this.dLv.setOtherParams(str);
        this.dLw.a(this.dLv);
        this.dLv.f(this.dLw);
    }

    public View getView() {
        return this.dLv.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.dLv != null) {
            this.dLv.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aLo() {
        if (this.dLw != null) {
            this.dLw.onDestory();
        }
        if (this.dLv != null) {
            this.dLv.aLn();
        }
    }
}
