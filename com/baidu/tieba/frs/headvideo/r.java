package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ ForumHeadVideoView bPh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ForumHeadVideoView forumHeadVideoView) {
        this.bPh = forumHeadVideoView;
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
        list = this.bPh.aLB;
        if (list != null) {
            list2 = this.bPh.aLB;
            if (list2.size() > 0) {
                list3 = this.bPh.aLB;
                y.d(list3, 0);
                e currentVideoItemView = this.bPh.getCurrentVideoItemView();
                e swapVideoItemView = this.bPh.getSwapVideoItemView();
                if (currentVideoItemView != null) {
                    currentVideoItemView.clearAnimation();
                    currentVideoItemView.stopPlayback();
                    currentVideoItemView.setVisibility(8);
                    this.bPh.removeView(currentVideoItemView);
                    int childCount = this.bPh.getChildCount();
                    if (swapVideoItemView != null) {
                        swapVideoItemView.clearAnimation();
                        this.bPh.g(swapVideoItemView, childCount - 1, childCount);
                    }
                    hasMore = this.bPh.hasMore();
                    if (!hasMore) {
                        list4 = this.bPh.aLB;
                    }
                    this.bPh.addView(currentVideoItemView, 0);
                    this.bPh.Zv();
                    this.bPh.Zq();
                    this.bPh.hK(this.bPh.getChildCount());
                }
            }
        }
        this.bPh.bOV = true;
    }
}
