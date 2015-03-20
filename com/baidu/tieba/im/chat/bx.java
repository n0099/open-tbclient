package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView aXQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(MsgleftView msgleftView) {
        this.aXQ = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.aXQ.aXO;
        touchType.set(true);
        return true;
    }
}
