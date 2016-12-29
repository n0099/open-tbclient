package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ForumHeadVideoView bLk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumHeadVideoView forumHeadVideoView) {
        this.bLk = forumHeadVideoView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
        if (r2 < com.baidu.tbadk.core.util.x.s(r1)) goto L15;
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
        list = this.bLk.aUm;
        if (list != null) {
            list2 = this.bLk.aUm;
            if (list2.size() > 0) {
                list3 = this.bLk.aUm;
                x.d(list3, 0);
                c currentVideoItemView = this.bLk.getCurrentVideoItemView();
                c swapVideoItemView = this.bLk.getSwapVideoItemView();
                currentVideoItemView.aap();
                if (currentVideoItemView != null) {
                    currentVideoItemView.clearAnimation();
                    currentVideoItemView.stopPlayback();
                    currentVideoItemView.setVisibility(8);
                    this.bLk.removeView(currentVideoItemView);
                    int childCount = this.bLk.getChildCount();
                    if (swapVideoItemView != null) {
                        swapVideoItemView.clearAnimation();
                        this.bLk.f(swapVideoItemView, childCount - 1, childCount);
                    }
                    hasMore = this.bLk.hasMore();
                    if (!hasMore) {
                        list4 = this.bLk.aUm;
                    }
                    this.bLk.addView(currentVideoItemView, 0);
                    this.bLk.aaD();
                    this.bLk.IV();
                    this.bLk.hD(this.bLk.getChildCount());
                }
            }
        }
        this.bLk.bKW = true;
    }
}
