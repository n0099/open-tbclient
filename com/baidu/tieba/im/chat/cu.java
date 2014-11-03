package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cu implements View.OnClickListener {
    final /* synthetic */ MsgrightView aPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(MsgrightView msgrightView) {
        this.aPN = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPN.aOY.a(view, 1, this.aPN.UC, 0L);
    }
}
