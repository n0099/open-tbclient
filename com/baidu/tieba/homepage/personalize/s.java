package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(b bVar) {
        this.ctz = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ctz.hideTip();
    }
}
