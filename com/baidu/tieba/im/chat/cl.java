package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cl implements View.OnClickListener {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b.a(view, 2, this.a.e, 0L);
    }
}
