package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements NoNetworkView.a {
    final /* synthetic */ HotTopicActivity bGR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(HotTopicActivity hotTopicActivity) {
        this.bGR = hotTopicActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        i iVar;
        i iVar2;
        com.baidu.tieba.hottopic.view.a aVar;
        com.baidu.tieba.hottopic.view.a aVar2;
        i iVar3;
        i iVar4;
        if (z) {
            iVar = this.bGR.bGH;
            if (iVar != null) {
                iVar2 = this.bGR.bGH;
                if (iVar2.getHotTopicData() != null) {
                    iVar3 = this.bGR.bGH;
                    if (iVar3.getHotTopicData().VA() != null) {
                        iVar4 = this.bGR.bGH;
                        if (iVar4.getHotTopicData().VA().size() != 0) {
                            return;
                        }
                    }
                }
                HotTopicActivity hotTopicActivity = this.bGR;
                aVar = this.bGR.bGG;
                hotTopicActivity.hideNetRefreshView(aVar.VF());
                aVar2 = this.bGR.bGG;
                aVar2.VK();
            }
        }
    }
}
