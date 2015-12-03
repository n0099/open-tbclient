package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ MsgleftView bIb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgleftView msgleftView) {
        this.bIb = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bIb.bHn.onItemViewClick(view, 2, this.bIb.apI, 0L);
    }
}
