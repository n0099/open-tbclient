package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FloatingPersonalChatView floatingPersonalChatView) {
        this.bas = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bas.On();
    }
}
