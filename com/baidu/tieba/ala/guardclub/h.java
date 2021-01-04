package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes11.dex */
public class h {
    private com.baidu.tieba.ala.guardclub.view.d haO;
    private e.a haQ = new e.a() { // from class: com.baidu.tieba.ala.guardclub.h.1
    };
    private BdUniqueId bwz = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e haP = new com.baidu.tieba.ala.guardclub.model.e(this.bwz, this.haQ);

    public h(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.haO = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.haO.setOtherParams(str);
        this.haP.a(this.haO);
        this.haO.f(this.haP);
    }

    public View getView() {
        return this.haO.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.haO != null) {
            this.haO.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.haP != null) {
            this.haP.onDestory();
        }
        if (this.haO != null) {
            this.haO.bYO();
        }
    }
}
