package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView boI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(MsgleftView msgleftView) {
        this.boI = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.boI.boG;
        touchType.set(true);
        return true;
    }
}
