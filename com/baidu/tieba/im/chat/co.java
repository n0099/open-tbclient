package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class co implements View.OnClickListener {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b.a(view, 2, this.a.d, 0L);
    }
}
