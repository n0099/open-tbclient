package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ AbsMsglistView aZo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AbsMsglistView absMsglistView) {
        this.aZo = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aZo.mEdtMsgSendText.requestFocus();
        this.aZo.mEdtMsgSendText.setSelection(this.aZo.mEdtMsgSendText.getText().toString().length());
    }
}
