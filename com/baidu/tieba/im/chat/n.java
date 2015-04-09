package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ AbsMsglistView aWI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AbsMsglistView absMsglistView) {
        this.aWI = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aWI.mEdtMsgSendText.requestFocus();
        this.aWI.mEdtMsgSendText.setSelection(this.aWI.mEdtMsgSendText.getText().toString().length());
    }
}
