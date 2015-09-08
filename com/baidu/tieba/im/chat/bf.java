package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnLongClickListener {
    final /* synthetic */ MsgleftView bpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(MsgleftView msgleftView) {
        this.bpg = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.bpg.bpe;
        touchType.set(true);
        return true;
    }
}
