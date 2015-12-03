package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements NoNetworkView.a {
    final /* synthetic */ HotTopicActivity bDn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(HotTopicActivity hotTopicActivity) {
        this.bDn = hotTopicActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        i iVar;
        i iVar2;
        com.baidu.tieba.hottopic.view.a aVar;
        com.baidu.tieba.hottopic.view.a aVar2;
        i iVar3;
        i iVar4;
        if (z) {
            iVar = this.bDn.bDd;
            if (iVar != null) {
                iVar2 = this.bDn.bDd;
                if (iVar2.getHotTopicData() != null) {
                    iVar3 = this.bDn.bDd;
                    if (iVar3.getHotTopicData().Ux() != null) {
                        iVar4 = this.bDn.bDd;
                        if (iVar4.getHotTopicData().Ux().size() != 0) {
                            return;
                        }
                    }
                }
                HotTopicActivity hotTopicActivity = this.bDn;
                aVar = this.bDn.bDc;
                hotTopicActivity.hideNetRefreshView(aVar.UC());
                aVar2 = this.bDn.bDc;
                aVar2.TU();
            }
        }
    }
}
