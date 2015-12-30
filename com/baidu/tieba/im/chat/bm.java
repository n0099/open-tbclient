package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ MsgrightView bLS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MsgrightView msgrightView) {
        this.bLS = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bLS.bKU.onItemViewClick(view, 6, this.bLS.anc, 0L);
    }
}
