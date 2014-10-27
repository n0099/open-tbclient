package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ AbsMsglistView aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView) {
        this.aNB = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aNB.mEdtMsgSendText.requestFocus();
        this.aNB.mEdtMsgSendText.setSelection(this.aNB.mEdtMsgSendText.getText().toString().length());
    }
}
