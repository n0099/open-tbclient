package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class br implements View.OnClickListener {
    final /* synthetic */ MsgrightView aRt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(MsgrightView msgrightView) {
        this.aRt = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aRt.mItemViewClickListener.onItemViewClick(view, 1, this.aRt.mPosition, 0L);
    }
}
