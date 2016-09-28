package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bo implements View.OnClickListener {
    final /* synthetic */ MsgrightView cVB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(MsgrightView msgrightView) {
        this.cVB = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cVB.cUE.a(view, 1, this.cVB.aok, 0L);
    }
}
