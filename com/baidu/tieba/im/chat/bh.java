package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView cKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(MsgleftView msgleftView) {
        this.cKz = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.cKz.cKx;
        touchType.set(true);
        return true;
    }
}
