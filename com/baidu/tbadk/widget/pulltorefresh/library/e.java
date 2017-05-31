package com.baidu.tbadk.widget.pulltorefresh.library;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ PullToRefreshBase aMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PullToRefreshBase pullToRefreshBase) {
        this.aMh = pullToRefreshBase;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aMh.requestLayout();
    }
}
