package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tieba.frs.headvideo.e;
import java.util.List;
/* loaded from: classes.dex */
class n implements e.a {
    final /* synthetic */ ForumHeadVideoView bLk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumHeadVideoView forumHeadVideoView) {
        this.bLk = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.e.a
    public void fJ(String str) {
    }

    @Override // com.baidu.tieba.frs.headvideo.e.a
    public void c(int i, List<BannerThreadInfoData> list) {
        List list2;
        List list3;
        list2 = this.bLk.aUm;
        if (list2 != null && list != null) {
            list3 = this.bLk.aUm;
            list3.addAll(list);
        }
    }
}
