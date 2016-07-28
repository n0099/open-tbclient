package com.baidu.tbadk.widget.pulltorefresh.library;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ PullToRefreshBase aEx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PullToRefreshBase pullToRefreshBase) {
        this.aEx = pullToRefreshBase;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aEx.requestLayout();
    }
}
