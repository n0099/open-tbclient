package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView aSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(MsgleftView msgleftView) {
        this.aSx = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.aSx.aSv;
        touchType.set(true);
        return true;
    }
}
