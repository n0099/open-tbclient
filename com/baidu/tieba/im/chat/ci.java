package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class ci implements View.OnClickListener {
    final /* synthetic */ MsgrightView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(MsgrightView msgrightView) {
        this.a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c.a(view, 6, this.a.f, 0L);
    }
}
