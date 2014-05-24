package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.d.requestFocus();
        this.a.d.setSelection(this.a.d.getText().toString().length());
    }
}
