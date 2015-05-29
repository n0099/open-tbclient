package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class by implements View.OnClickListener {
    final /* synthetic */ MsgleftView baN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(MsgleftView msgleftView) {
        this.baN = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.baN.aZY.onItemViewClick(view, 2, this.baN.mPosition, 0L);
    }
}
