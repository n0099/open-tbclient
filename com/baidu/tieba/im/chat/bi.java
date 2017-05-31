package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ MsgleftView cPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgleftView msgleftView) {
        this.cPX = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cPX.cPk.a(view, 2, this.cPX.atn, 0L);
    }
}
