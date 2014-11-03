package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ AbsMsglistView aNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView) {
        this.aNP = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aNP.mEdtMsgSendText.requestFocus();
        this.aNP.mEdtMsgSendText.setSelection(this.aNP.mEdtMsgSendText.getText().toString().length());
    }
}
