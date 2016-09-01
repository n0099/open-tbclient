package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ ForumHeadVideoView ccd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ForumHeadVideoView forumHeadVideoView) {
        this.ccd = forumHeadVideoView;
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
        list = this.ccd.aRP;
        if (list != null) {
            list2 = this.ccd.aRP;
            if (list2.size() > 0) {
                list3 = this.ccd.aRP;
                y.d(list3, 0);
                e currentVideoItemView = this.ccd.getCurrentVideoItemView();
                e swapVideoItemView = this.ccd.getSwapVideoItemView();
                if (currentVideoItemView != null) {
                    currentVideoItemView.clearAnimation();
                    currentVideoItemView.stopPlayback();
                    currentVideoItemView.setVisibility(8);
                    this.ccd.removeView(currentVideoItemView);
                    int childCount = this.ccd.getChildCount();
                    if (swapVideoItemView != null) {
                        swapVideoItemView.clearAnimation();
                        this.ccd.g(swapVideoItemView, childCount - 1, childCount);
                    }
                    hasMore = this.ccd.hasMore();
                    if (!hasMore) {
                        list4 = this.ccd.aRP;
                    }
                    this.ccd.addView(currentVideoItemView, 0);
                    this.ccd.aeB();
                    this.ccd.aew();
                    this.ccd.in(this.ccd.getChildCount());
                }
            }
        }
        this.ccd.cbP = true;
    }
}
