package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class by implements View.OnClickListener {
    final /* synthetic */ MsgleftView aYg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(MsgleftView msgleftView) {
        this.aYg = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aYg.aXs.onItemViewClick(view, 2, this.aYg.mPosition, 0L);
    }
}
