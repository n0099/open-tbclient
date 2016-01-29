package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements NoNetworkView.a {
    final /* synthetic */ HotTopicActivity bKr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(HotTopicActivity hotTopicActivity) {
        this.bKr = hotTopicActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        m mVar;
        m mVar2;
        com.baidu.tieba.hottopic.view.c cVar;
        com.baidu.tieba.hottopic.view.c cVar2;
        com.baidu.tieba.hottopic.view.c cVar3;
        m mVar3;
        m mVar4;
        if (z) {
            mVar = this.bKr.bKg;
            if (mVar != null) {
                mVar2 = this.bKr.bKg;
                if (mVar2.getHotTopicData() != null) {
                    mVar3 = this.bKr.bKg;
                    if (mVar3.getHotTopicData().XT() != null) {
                        mVar4 = this.bKr.bKg;
                        if (mVar4.getHotTopicData().XT().size() != 0) {
                            return;
                        }
                    }
                }
                HotTopicActivity hotTopicActivity = this.bKr;
                cVar = this.bKr.bKf;
                hotTopicActivity.hideNetRefreshView(cVar.Yb());
                HotTopicActivity hotTopicActivity2 = this.bKr;
                cVar2 = this.bKr.bKf;
                hotTopicActivity2.showLoadingView(cVar2.Yb(), true);
                cVar3 = this.bKr.bKf;
                cVar3.XZ();
            }
        }
    }
}
