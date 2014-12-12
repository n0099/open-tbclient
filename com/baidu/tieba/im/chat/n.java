package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ AbsMsglistView aQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AbsMsglistView absMsglistView) {
        this.aQh = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQh.mEdtMsgSendText.requestFocus();
        this.aQh.mEdtMsgSendText.setSelection(this.aQh.mEdtMsgSendText.getText().toString().length());
    }
}
