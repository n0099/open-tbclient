package com.baidu.tbadk.coreExtra.act;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.a.a;
        editHeadActivity.b("normal");
    }
}
