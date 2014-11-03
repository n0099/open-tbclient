package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ AbsMsglistView aNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AbsMsglistView absMsglistView) {
        this.aNP = absMsglistView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aNP.sendmsgCloseSoftkey();
        this.aNP.sendmsgShowMore();
        this.aNP.sendmsgShowText();
    }
}
