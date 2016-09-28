package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tieba.frs.headvideo.g;
import java.util.List;
/* loaded from: classes.dex */
class p implements g.a {
    final /* synthetic */ ForumHeadVideoView ccf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumHeadVideoView forumHeadVideoView) {
        this.ccf = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.g.a
    public void fK(String str) {
    }

    @Override // com.baidu.tieba.frs.headvideo.g.a
    public void c(int i, List<BannerThreadInfoData> list) {
        List list2;
        List list3;
        list2 = this.ccf.aSU;
        if (list2 != null && list != null) {
            list3 = this.ccf.aSU;
            list3.addAll(list);
        }
    }
}
