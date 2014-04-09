package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
final class cl implements View.OnClickListener {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.c.a(view, 2, this.a.f, 0L);
    }
}
