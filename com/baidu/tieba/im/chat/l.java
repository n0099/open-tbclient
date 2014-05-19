package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.d.requestFocus();
        this.a.d.setSelection(this.a.d.getText().toString().length());
    }
}
