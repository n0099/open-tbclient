package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class ct implements View.OnClickListener {
    final /* synthetic */ MsgrightView aPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(MsgrightView msgrightView) {
        this.aPN = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPN.aOY.a(view, 6, this.aPN.UC, 0L);
    }
}
