package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ MsgrightView baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(MsgrightView msgrightView) {
        this.baY = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.baY.aZZ.onItemViewClick(view, 6, this.baY.mPosition, 0L);
    }
}
