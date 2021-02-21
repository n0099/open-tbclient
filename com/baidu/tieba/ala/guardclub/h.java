package com.baidu.tieba.ala.guardclub;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.tieba.ala.guardclub.model.e;
/* loaded from: classes11.dex */
public class h {
    private com.baidu.tieba.ala.guardclub.view.d gZg;
    private e.a gZi = new e.a() { // from class: com.baidu.tieba.ala.guardclub.h.1
    };
    private BdUniqueId aCW = BdUniqueId.gen();
    private com.baidu.tieba.ala.guardclub.model.e gZh = new com.baidu.tieba.ala.guardclub.model.e(this.aCW, this.gZi);

    public h(BaseActivity baseActivity, String str, BdUniqueId bdUniqueId) {
        this.gZg = new com.baidu.tieba.ala.guardclub.view.d(baseActivity, bdUniqueId);
        this.gZg.setOtherParams(str);
        this.gZh.a(this.gZg);
        this.gZg.f(this.gZh);
    }

    public View getView() {
        return this.gZg.getView();
    }

    public void notifyDataSetInvalidated() {
        if (this.gZg != null) {
            this.gZg.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageDestroy() {
        if (this.gZh != null) {
            this.gZh.onDestory();
        }
        if (this.gZg != null) {
            this.gZg.bVJ();
        }
    }
}
