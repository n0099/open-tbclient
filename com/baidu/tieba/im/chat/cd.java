package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ MsgrightView aYq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(MsgrightView msgrightView) {
        this.aYq = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aYq.aXs.onItemViewClick(view, 1, this.aYq.mPosition, 0L);
    }
}
