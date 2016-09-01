package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bo implements View.OnClickListener {
    final /* synthetic */ MsgrightView cUh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(MsgrightView msgrightView) {
        this.cUh = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cUh.cTk.a(view, 1, this.cUh.aoC, 0L);
    }
}
