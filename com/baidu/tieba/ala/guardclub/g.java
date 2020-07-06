package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.ala.guardclub.view.d fJr;
    private e.a fJt = new e.a() { // from class: com.baidu.tieba.ala.guardclub.g.1
    };
    private BdUniqueId aZD = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e fJs = new com.baidu.tieba.ala.guardclub.model.e(this.aZD, this.fJt);

    public g(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.fJr = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.fJr.setOtherParams(str);
        this.fJs.a(this.fJr);
        this.fJr.f(this.fJs);
    }

    public View getView() {
        return this.fJr.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.fJr != null) {
            this.fJr.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDK() {
        if (this.fJs != null) {
            this.fJs.onDestory();
        }
        if (this.fJr != null) {
            this.fJr.bxu();
        }
    }
}
