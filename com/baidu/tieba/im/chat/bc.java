package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnLongClickListener {
    final /* synthetic */ as bsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(as asVar) {
        this.bsa = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bsa.brt.onItemViewLongClick(view, 3, this.bsa.anK, 0L);
        return true;
    }
}
