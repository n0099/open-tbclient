package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ AbsMsglistView aNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AbsMsglistView absMsglistView) {
        this.aNP = absMsglistView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        this.aNP.sendmsgCloseMore();
        this.aNP.sendmsgShowText();
        imageView = this.aNP.mBtnMsgSendSoftkey;
        imageView.postDelayed(new p(this), 100L);
    }
}
