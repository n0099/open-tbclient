package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView cFD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgleftView msgleftView) {
        this.cFD = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.cFD.cFB;
        touchType.set(true);
        return true;
    }
}
