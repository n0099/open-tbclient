package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ MsgleftView cOg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgleftView msgleftView) {
        this.cOg = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cOg.cNs.a(view, 2, this.cOg.atx, 0L);
    }
}
