package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ as can;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(as asVar) {
        this.can = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.can.bZF.a(view, 10, this.can.aka, 0L);
    }
}
