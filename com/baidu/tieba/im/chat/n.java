package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ AbsMsglistView aRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AbsMsglistView absMsglistView) {
        this.aRl = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aRl.mEdtMsgSendText.requestFocus();
        this.aRl.mEdtMsgSendText.setSelection(this.aRl.mEdtMsgSendText.getText().toString().length());
    }
}
