package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ MsgleftView boI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(MsgleftView msgleftView) {
        this.boI = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.boI.bnV.onItemViewClick(view, 2, this.boI.anz, 0L);
    }
}
