package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
final class cj implements View.OnClickListener {
    final /* synthetic */ MsgrightView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(MsgrightView msgrightView) {
        this.a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.c.a(view, 1, this.a.f);
    }
}
