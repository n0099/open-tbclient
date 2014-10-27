package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class ct implements View.OnClickListener {
    final /* synthetic */ MsgrightView aPz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(MsgrightView msgrightView) {
        this.aPz = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPz.aOK.a(view, 6, this.aPz.Uy, 0L);
    }
}
