package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ AbsMsglistView aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AbsMsglistView absMsglistView) {
        this.aNB = absMsglistView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aNB.sendmsgCloseSoftkey();
        this.aNB.sendmsgShowMore();
        this.aNB.sendmsgShowText();
    }
}
