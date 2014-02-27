package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class by implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.a.v;
        touchType.set(true);
        return true;
    }
}
