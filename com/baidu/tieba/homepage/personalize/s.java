package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(b bVar) {
        this.this$0 = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.hideTip();
    }
}
