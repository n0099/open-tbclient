package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bo implements View.OnClickListener {
    final /* synthetic */ MsgrightView dbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(MsgrightView msgrightView) {
        this.dbm = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dbm.dam.a(view, 1, this.dbm.ape, 0L);
    }
}
