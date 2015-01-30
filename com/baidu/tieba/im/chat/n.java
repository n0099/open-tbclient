package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ AbsMsglistView aRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AbsMsglistView absMsglistView) {
        this.aRm = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aRm.mEdtMsgSendText.requestFocus();
        this.aRm.mEdtMsgSendText.setSelection(this.aRm.mEdtMsgSendText.getText().toString().length());
    }
}
