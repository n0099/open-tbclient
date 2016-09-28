package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements Runnable {
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(m mVar) {
        this.this$0 = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.hideTip();
    }
}
