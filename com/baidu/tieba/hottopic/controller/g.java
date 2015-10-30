package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements NoNetworkView.a {
    final /* synthetic */ HotTopicActivity boL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HotTopicActivity hotTopicActivity) {
        this.boL = hotTopicActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        h hVar;
        h hVar2;
        com.baidu.tieba.hottopic.view.a aVar;
        com.baidu.tieba.hottopic.view.a aVar2;
        h hVar3;
        h hVar4;
        if (z) {
            hVar = this.boL.boA;
            if (hVar != null) {
                hVar2 = this.boL.boA;
                if (hVar2.getHotTopicData() != null) {
                    hVar3 = this.boL.boA;
                    if (hVar3.getHotTopicData().QQ() != null) {
                        hVar4 = this.boL.boA;
                        if (hVar4.getHotTopicData().QQ().size() != 0) {
                            return;
                        }
                    }
                }
                HotTopicActivity hotTopicActivity = this.boL;
                aVar = this.boL.boz;
                hotTopicActivity.hideNetRefreshView(aVar.QW());
                aVar2 = this.boL.boz;
                aVar2.Rb();
            }
        }
    }
}
