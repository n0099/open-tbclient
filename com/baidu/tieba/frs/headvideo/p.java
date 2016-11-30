package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ForumHeadVideoView cfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumHeadVideoView forumHeadVideoView) {
        this.cfB = forumHeadVideoView;
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
        list = this.cfB.aUV;
        if (list != null) {
            list2 = this.cfB.aUV;
            if (list2.size() > 0) {
                list3 = this.cfB.aUV;
                x.d(list3, 0);
                c currentVideoItemView = this.cfB.getCurrentVideoItemView();
                c swapVideoItemView = this.cfB.getSwapVideoItemView();
                currentVideoItemView.afT();
                if (currentVideoItemView != null) {
                    currentVideoItemView.clearAnimation();
                    currentVideoItemView.stopPlayback();
                    currentVideoItemView.setVisibility(8);
                    this.cfB.removeView(currentVideoItemView);
                    int childCount = this.cfB.getChildCount();
                    if (swapVideoItemView != null) {
                        swapVideoItemView.clearAnimation();
                        this.cfB.g(swapVideoItemView, childCount - 1, childCount);
                    }
                    hasMore = this.cfB.hasMore();
                    if (!hasMore) {
                        list4 = this.cfB.aUV;
                    }
                    this.cfB.addView(currentVideoItemView, 0);
                    this.cfB.agh();
                    this.cfB.JA();
                    this.cfB.it(this.cfB.getChildCount());
                }
            }
        }
        this.cfB.cfn = true;
    }
}
