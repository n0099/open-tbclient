package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView aYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FloatingPersonalChatView floatingPersonalChatView) {
        this.aYV = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aYV.NR();
    }
}
