package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ ForumHeadVideoView ccf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ForumHeadVideoView forumHeadVideoView) {
        this.ccf = forumHeadVideoView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
        if (r2 < com.baidu.tbadk.core.util.y.s(r1)) goto L15;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        List list;
        List list2;
        List list3;
        boolean hasMore;
        List list4;
        list = this.ccf.aSU;
        if (list != null) {
            list2 = this.ccf.aSU;
            if (list2.size() > 0) {
                list3 = this.ccf.aSU;
                y.d(list3, 0);
                e currentVideoItemView = this.ccf.getCurrentVideoItemView();
                e swapVideoItemView = this.ccf.getSwapVideoItemView();
                if (currentVideoItemView != null) {
                    currentVideoItemView.clearAnimation();
                    currentVideoItemView.stopPlayback();
                    currentVideoItemView.setVisibility(8);
                    this.ccf.removeView(currentVideoItemView);
                    int childCount = this.ccf.getChildCount();
                    if (swapVideoItemView != null) {
                        swapVideoItemView.clearAnimation();
                        this.ccf.g(swapVideoItemView, childCount - 1, childCount);
                    }
                    hasMore = this.ccf.hasMore();
                    if (!hasMore) {
                        list4 = this.ccf.aSU;
                    }
                    this.ccf.addView(currentVideoItemView, 0);
                    this.ccf.aeP();
                    this.ccf.Jp();
                    this.ccf.is(this.ccf.getChildCount());
                }
            }
        }
        this.ccf.cbR = true;
    }
}
