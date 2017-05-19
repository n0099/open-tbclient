package com.baidu.tbadk.widget.pulltorefresh.library;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ PullToRefreshBase aMk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PullToRefreshBase pullToRefreshBase) {
        this.aMk = pullToRefreshBase;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aMk.requestLayout();
    }
}
