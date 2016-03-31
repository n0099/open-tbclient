package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView bZO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(MsgleftView msgleftView) {
        this.bZO = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.bZO.bZM;
        touchType.set(true);
        return true;
    }
}
