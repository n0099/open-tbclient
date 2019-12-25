package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.h;
/* loaded from: classes2.dex */
public class e {
    private com.baidu.tieba.ala.guardclub.view.b ezH;
    private h.a ezJ = new h.a() { // from class: com.baidu.tieba.ala.guardclub.e.1
    };
    private BdUniqueId anM = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.h ezI = new com.baidu.tieba.ala.guardclub.model.h(this.anM, this.ezJ);

    public e(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.ezH = new com.baidu.tieba.ala.guardclub.view.b(baseActivity, bdUniqueId);
        this.ezH.setOtherParams(str);
        this.ezI.a(this.ezH);
        this.ezH.f(this.ezI);
    }

    public View getView() {
        return this.ezH.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.ezH != null) {
            this.ezH.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void anO() {
        if (this.ezI != null) {
            this.ezI.onDestory();
        }
        if (this.ezH != null) {
            this.ezH.bcx();
        }
    }
}
