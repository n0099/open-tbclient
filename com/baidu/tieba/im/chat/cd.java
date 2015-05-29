package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ MsgrightView baX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(MsgrightView msgrightView) {
        this.baX = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.baX.aZY.onItemViewClick(view, 1, this.baX.mPosition, 0L);
    }
}
