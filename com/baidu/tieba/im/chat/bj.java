package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ MsgleftView dbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.dbc = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dbc.dam.a(view, 2, this.dbc.ape, 0L);
    }
}
