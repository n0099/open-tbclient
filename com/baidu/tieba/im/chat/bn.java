package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bn implements View.OnClickListener {
    final /* synthetic */ MsgrightView btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(MsgrightView msgrightView) {
        this.btf = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.btf.bsh.onItemViewClick(view, 1, this.btf.anQ, 0L);
    }
}
