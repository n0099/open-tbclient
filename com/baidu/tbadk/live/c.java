package com.baidu.tbadk.live;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ a abz;
    private final /* synthetic */ String val$bduss;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.abz = aVar;
        this.val$bduss = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abz.getAccesssTokenInBackground(this.val$bduss);
    }
}
