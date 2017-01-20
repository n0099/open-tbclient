package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.w;
import java.util.List;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ ForumHeadVideoView bRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumHeadVideoView forumHeadVideoView) {
        this.bRD = forumHeadVideoView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
        if (r2 < com.baidu.tbadk.core.util.w.r(r1)) goto L15;
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
        list = this.bRD.aPE;
        if (list != null) {
            list2 = this.bRD.aPE;
            if (list2.size() > 0) {
                list3 = this.bRD.aPE;
                w.d(list3, 0);
                c currentVideoItemView = this.bRD.getCurrentVideoItemView();
                c swapVideoItemView = this.bRD.getSwapVideoItemView();
                currentVideoItemView.abu();
                if (currentVideoItemView != null) {
                    currentVideoItemView.clearAnimation();
                    currentVideoItemView.stopPlayback();
                    currentVideoItemView.setVisibility(8);
                    this.bRD.removeView(currentVideoItemView);
                    int childCount = this.bRD.getChildCount();
                    if (swapVideoItemView != null) {
                        swapVideoItemView.clearAnimation();
                        this.bRD.f(swapVideoItemView, childCount - 1, childCount);
                    }
                    hasMore = this.bRD.hasMore();
                    if (!hasMore) {
                        list4 = this.bRD.aPE;
                    }
                    this.bRD.addView(currentVideoItemView, 0);
                    this.bRD.abJ();
                    this.bRD.Jj();
                    this.bRD.iq(this.bRD.getChildCount());
                }
            }
        }
        this.bRD.bRp = true;
    }
}
