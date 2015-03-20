package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ MsgrightView aYa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(MsgrightView msgrightView) {
        this.aYa = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aYa.aXc.onItemViewClick(view, 6, this.aYa.mPosition, 0L);
    }
}
