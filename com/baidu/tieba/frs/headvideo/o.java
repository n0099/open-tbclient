package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ ForumHeadVideoView bYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumHeadVideoView forumHeadVideoView) {
        this.bYL = forumHeadVideoView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
        if (r2 < com.baidu.tbadk.core.util.x.p(r1)) goto L15;
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
        list = this.bYL.aVq;
        if (list != null) {
            list2 = this.bYL.aVq;
            if (list2.size() > 0) {
                list3 = this.bYL.aVq;
                x.d(list3, 0);
                c currentVideoItemView = this.bYL.getCurrentVideoItemView();
                c swapVideoItemView = this.bYL.getSwapVideoItemView();
                currentVideoItemView.acr();
                if (currentVideoItemView != null) {
                    currentVideoItemView.clearAnimation();
                    currentVideoItemView.stopPlayback();
                    currentVideoItemView.setVisibility(8);
                    this.bYL.removeView(currentVideoItemView);
                    int childCount = this.bYL.getChildCount();
                    if (swapVideoItemView != null) {
                        swapVideoItemView.clearAnimation();
                        this.bYL.f(swapVideoItemView, childCount - 1, childCount);
                    }
                    hasMore = this.bYL.hasMore();
                    if (!hasMore) {
                        list4 = this.bYL.aVq;
                    }
                    this.bYL.addView(currentVideoItemView, 0);
                    this.bYL.acG();
                    this.bYL.JO();
                    this.bYL.im(this.bYL.getChildCount());
                }
            }
        }
        this.bYL.bYx = true;
    }
}
