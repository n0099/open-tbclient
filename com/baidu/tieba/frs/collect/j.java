package com.baidu.tieba.frs.collect;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ MyCollectFrsActivity bkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MyCollectFrsActivity myCollectFrsActivity) {
        this.bkc = myCollectFrsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (com.baidu.adp.lib.util.k.jh()) {
            aVar = this.bkc.bjW;
            aVar.firstLoadData();
        }
    }
}
