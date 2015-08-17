package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bl implements View.OnClickListener {
    final /* synthetic */ MsgrightView boS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(MsgrightView msgrightView) {
        this.boS = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.boS.bnV.onItemViewClick(view, 1, this.boS.anz, 0L);
    }
}
