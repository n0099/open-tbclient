package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ MsgrightView bsB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MsgrightView msgrightView) {
        this.bsB = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bsB.brD.onItemViewClick(view, 6, this.bsB.anL, 0L);
    }
}
