package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d fyh;
    private e.a fyj = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId aWV = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e fyi = new com.baidu.tieba.ala.guardclub.model.e(this.aWV, this.fyj);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.fyh = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.fyh.setOtherParams(str);
        this.fyi.a(this.fyh);
        this.fyh.f(this.fyi);
    }

    public View getView() {
        return this.fyh.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.fyh != null) {
            this.fyh.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCE() {
        if (this.fyi != null) {
            this.fyi.onDestory();
        }
        if (this.fyh != null) {
            this.fyh.buy();
        }
    }
}
