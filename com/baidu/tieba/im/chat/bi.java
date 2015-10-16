package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ MsgleftView bsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgleftView msgleftView) {
        this.bsr = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bsr.brD.onItemViewClick(view, 2, this.bsr.anL, 0L);
    }
}
