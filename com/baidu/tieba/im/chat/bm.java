package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView aRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MsgleftView msgleftView) {
        this.aRo = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.aRo.aRm;
        touchType.set(true);
        return true;
    }
}
