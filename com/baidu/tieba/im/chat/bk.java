package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ MsgrightView boS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MsgrightView msgrightView) {
        this.boS = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.boS.bnV.onItemViewClick(view, 6, this.boS.anz, 0L);
    }
}
