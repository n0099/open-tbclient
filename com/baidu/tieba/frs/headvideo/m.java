package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel;
import java.util.List;
/* loaded from: classes.dex */
class m implements ForumHeadVideoListModel.a {
    final /* synthetic */ ForumHeadVideoView bYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ForumHeadVideoView forumHeadVideoView) {
        this.bYL = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel.a
    public void fv(String str) {
    }

    @Override // com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel.a
    public void c(int i, List<BannerThreadInfoData> list) {
        List list2;
        List list3;
        list2 = this.bYL.aVq;
        if (list2 != null && list != null) {
            list3 = this.bYL.aVq;
            list3.addAll(list);
        }
    }
}
