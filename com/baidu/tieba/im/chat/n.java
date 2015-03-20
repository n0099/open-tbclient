package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ AbsMsglistView aWs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AbsMsglistView absMsglistView) {
        this.aWs = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aWs.mEdtMsgSendText.requestFocus();
        this.aWs.mEdtMsgSendText.setSelection(this.aWs.mEdtMsgSendText.getText().toString().length());
    }
}
