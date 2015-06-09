package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ AbsMsglistView aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AbsMsglistView absMsglistView) {
        this.aZp = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aZp.mEdtMsgSendText.requestFocus();
        this.aZp.mEdtMsgSendText.setSelection(this.aZp.mEdtMsgSendText.getText().toString().length());
    }
}
