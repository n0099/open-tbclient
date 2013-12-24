package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cm implements View.OnClickListener {
    final /* synthetic */ MsgrightView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(MsgrightView msgrightView) {
        this.a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c.a(view, 1, this.a.f, 0L);
    }
}
