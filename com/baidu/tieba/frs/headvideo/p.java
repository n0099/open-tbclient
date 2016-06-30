package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tieba.frs.headvideo.g;
import java.util.List;
/* loaded from: classes.dex */
class p implements g.a {
    final /* synthetic */ ForumHeadVideoView bPh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumHeadVideoView forumHeadVideoView) {
        this.bPh = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.g.a
    public void fF(String str) {
    }

    @Override // com.baidu.tieba.frs.headvideo.g.a
    public void c(int i, List<BannerThreadInfoData> list) {
        List list2;
        List list3;
        list2 = this.bPh.aLB;
        if (list2 != null && list != null) {
            list3 = this.bPh.aLB;
            list3.addAll(list);
        }
    }
}
