package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class by implements View.OnClickListener {
    final /* synthetic */ MsgleftView baO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(MsgleftView msgleftView) {
        this.baO = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.baO.aZZ.onItemViewClick(view, 2, this.baO.mPosition, 0L);
    }
}
