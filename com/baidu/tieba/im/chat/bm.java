package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ MsgrightView bPG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MsgrightView msgrightView) {
        this.bPG = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bPG.bOI.a(view, 6, this.bPG.anV, 0L);
    }
}
