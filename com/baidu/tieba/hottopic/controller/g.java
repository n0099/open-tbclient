package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements NoNetworkView.a {
    final /* synthetic */ HotTopicActivity boA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HotTopicActivity hotTopicActivity) {
        this.boA = hotTopicActivity;
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
            hVar = this.boA.bop;
            if (hVar != null) {
                hVar2 = this.boA.bop;
                if (hVar2.getHotTopicData() != null) {
                    hVar3 = this.boA.bop;
                    if (hVar3.getHotTopicData().QU() != null) {
                        hVar4 = this.boA.bop;
                        if (hVar4.getHotTopicData().QU().size() != 0) {
                            return;
                        }
                    }
                }
                HotTopicActivity hotTopicActivity = this.boA;
                aVar = this.boA.boo;
                hotTopicActivity.hideNetRefreshView(aVar.Ra());
                aVar2 = this.boA.boo;
                aVar2.Rf();
            }
        }
    }
}
