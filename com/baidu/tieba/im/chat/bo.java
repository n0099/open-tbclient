package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bo implements View.OnClickListener {
    final /* synthetic */ MsgrightView cFN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(MsgrightView msgrightView) {
        this.cFN = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cFN.cEP.a(view, 1, this.cFN.akG, 0L);
    }
}
