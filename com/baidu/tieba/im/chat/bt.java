package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bt implements View.OnClickListener {
    final /* synthetic */ MsgrightView aSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(MsgrightView msgrightView) {
        this.aSC = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aSC.mItemViewClickListener.onItemViewClick(view, 6, this.aSC.mPosition, 0L);
    }
}
