package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ MsgrightView btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MsgrightView msgrightView) {
        this.btf = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.btf.bsh.onItemViewClick(view, 6, this.btf.anQ, 0L);
    }
}
