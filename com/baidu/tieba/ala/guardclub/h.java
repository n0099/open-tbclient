package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes11.dex */
public class h {
    private com.baidu.tieba.ala.guardclub.view.d gYS;
    private e.a gYU = new e.a() { // from class: com.baidu.tieba.ala.guardclub.h.1
    };
    private BdUniqueId aCW = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gYT = new com.baidu.tieba.ala.guardclub.model.e(this.aCW, this.gYU);

    public h(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gYS = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gYS.setOtherParams(str);
        this.gYT.a(this.gYS);
        this.gYS.f(this.gYT);
    }

    public View getView() {
        return this.gYS.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gYS != null) {
            this.gYS.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.gYT != null) {
            this.gYT.onDestory();
        }
        if (this.gYS != null) {
            this.gYS.bVC();
        }
    }
}
