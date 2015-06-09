package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView baO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(MsgleftView msgleftView) {
        this.baO = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.baO.baM;
        touchType.set(true);
        return true;
    }
}
