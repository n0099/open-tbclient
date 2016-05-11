package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ MsgrightView caD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MsgrightView msgrightView) {
        this.caD = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.caD.bZF.a(view, 6, this.caD.aka, 0L);
    }
}
