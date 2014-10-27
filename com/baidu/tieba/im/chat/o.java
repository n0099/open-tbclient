package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ AbsMsglistView aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AbsMsglistView absMsglistView) {
        this.aNB = absMsglistView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        this.aNB.sendmsgCloseMore();
        this.aNB.sendmsgShowText();
        imageView = this.aNB.mBtnMsgSendSoftkey;
        imageView.postDelayed(new p(this), 100L);
    }
}
