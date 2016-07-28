package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bo implements View.OnClickListener {
    final /* synthetic */ MsgrightView cIC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(MsgrightView msgrightView) {
        this.cIC = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cIC.cHE.a(view, 1, this.cIC.alw, 0L);
    }
}
