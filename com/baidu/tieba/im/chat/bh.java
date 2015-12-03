package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView bIb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(MsgleftView msgleftView) {
        this.bIb = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.bIb.bHZ;
        touchType.set(true);
        return true;
    }
}
