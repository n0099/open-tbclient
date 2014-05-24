package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cn implements View.OnClickListener {
    final /* synthetic */ MsgrightView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(MsgrightView msgrightView) {
        this.a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b.a(view, 6, this.a.e, 0L);
    }
}
