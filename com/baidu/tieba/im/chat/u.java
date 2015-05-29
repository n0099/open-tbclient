package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ AbsMsglistView aZo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(AbsMsglistView absMsglistView) {
        this.aZo = absMsglistView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aZo.sendGovoiceEvent();
    }
}
