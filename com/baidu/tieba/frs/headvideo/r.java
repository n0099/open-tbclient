package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ ForumHeadVideoView bQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ForumHeadVideoView forumHeadVideoView) {
        this.bQU = forumHeadVideoView;
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
        list = this.bQU.aMv;
        if (list != null) {
            list2 = this.bQU.aMv;
            if (list2.size() > 0) {
                list3 = this.bQU.aMv;
                y.d(list3, 0);
                e currentVideoItemView = this.bQU.getCurrentVideoItemView();
                e swapVideoItemView = this.bQU.getSwapVideoItemView();
                if (currentVideoItemView != null) {
                    currentVideoItemView.clearAnimation();
                    currentVideoItemView.stopPlayback();
                    currentVideoItemView.setVisibility(8);
                    this.bQU.removeView(currentVideoItemView);
                    int childCount = this.bQU.getChildCount();
                    if (swapVideoItemView != null) {
                        swapVideoItemView.clearAnimation();
                        this.bQU.g(swapVideoItemView, childCount - 1, childCount);
                    }
                    hasMore = this.bQU.hasMore();
                    if (!hasMore) {
                        list4 = this.bQU.aMv;
                    }
                    this.bQU.addView(currentVideoItemView, 0);
                    this.bQU.ZR();
                    this.bQU.ZM();
                    this.bQU.hK(this.bQU.getChildCount());
                }
            }
        }
        this.bQU.bQH = true;
    }
}
