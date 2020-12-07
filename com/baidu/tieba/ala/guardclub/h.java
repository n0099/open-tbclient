package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes4.dex */
public class h {
    private com.baidu.tieba.ala.guardclub.view.d gOZ;
    private e.a gPb = new e.a() { // from class: com.baidu.tieba.ala.guardclub.h.1
    };
    private BdUniqueId brR = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gPa = new com.baidu.tieba.ala.guardclub.model.e(this.brR, this.gPb);

    public h(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gOZ = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gOZ.setOtherParams(str);
        this.gPa.a(this.gOZ);
        this.gOZ.f(this.gPa);
    }

    public View getView() {
        return this.gOZ.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gOZ != null) {
            this.gOZ.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baD() {
        if (this.gPa != null) {
            this.gPa.onDestory();
        }
        if (this.gOZ != null) {
            this.gOZ.bWi();
        }
    }
}
