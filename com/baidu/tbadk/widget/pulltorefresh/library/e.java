package com.baidu.tbadk.widget.pulltorefresh.library;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ PullToRefreshBase aHi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PullToRefreshBase pullToRefreshBase) {
        this.aHi = pullToRefreshBase;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aHi.requestLayout();
    }
}
