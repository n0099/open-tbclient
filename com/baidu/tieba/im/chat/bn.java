package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bn implements View.OnClickListener {
    final /* synthetic */ MsgrightView cKJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(MsgrightView msgrightView) {
        this.cKJ = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cKJ.cJM.a(view, 1, this.cKJ.atD, 0L);
    }
}
