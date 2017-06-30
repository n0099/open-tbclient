package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ MsgrightView cYd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MsgrightView msgrightView) {
        this.cYd = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cYd.cXg.a(view, 6, this.cYd.auq, 0L);
    }
}
