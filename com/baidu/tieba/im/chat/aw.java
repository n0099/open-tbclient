package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c.a(view, 2, this.a.f, 0L);
    }
}
