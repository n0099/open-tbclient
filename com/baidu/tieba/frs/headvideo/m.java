package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel;
import java.util.List;
/* loaded from: classes.dex */
class m implements ForumHeadVideoListModel.a {
    final /* synthetic */ ForumHeadVideoView bRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ForumHeadVideoView forumHeadVideoView) {
        this.bRD = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel.a
    public void fG(String str) {
    }

    @Override // com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel.a
    public void c(int i, List<BannerThreadInfoData> list) {
        List list2;
        List list3;
        list2 = this.bRD.aPE;
        if (list2 != null && list != null) {
            list3 = this.bRD.aPE;
            list3.addAll(list);
        }
    }
}
