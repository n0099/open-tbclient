package com.baidu.tieba.frs.collect;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ MyCollectFrsActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MyCollectFrsActivity myCollectFrsActivity) {
        this.bmY = myCollectFrsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (com.baidu.adp.lib.util.k.jq()) {
            aVar = this.bmY.bmS;
            aVar.QM();
        }
    }
}
