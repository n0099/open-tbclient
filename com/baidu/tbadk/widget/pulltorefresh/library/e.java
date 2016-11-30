package com.baidu.tbadk.widget.pulltorefresh.library;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ PullToRefreshBase aHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PullToRefreshBase pullToRefreshBase) {
        this.aHW = pullToRefreshBase;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aHW.requestLayout();
    }
}
