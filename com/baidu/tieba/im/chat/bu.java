package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bu implements View.OnClickListener {
    final /* synthetic */ MsgrightView aSB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(MsgrightView msgrightView) {
        this.aSB = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aSB.mItemViewClickListener.onItemViewClick(view, 1, this.aSB.mPosition, 0L);
    }
}
