package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView aPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(MsgleftView msgleftView) {
        this.aPq = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.aPq.aPo;
        touchType.set(true);
        return true;
    }
}
