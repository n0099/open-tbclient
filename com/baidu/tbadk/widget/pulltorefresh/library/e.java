package com.baidu.tbadk.widget.pulltorefresh.library;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ PullToRefreshBase aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PullToRefreshBase pullToRefreshBase) {
        this.aGf = pullToRefreshBase;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aGf.requestLayout();
    }
}
