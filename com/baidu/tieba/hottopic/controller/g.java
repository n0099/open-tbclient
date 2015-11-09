package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements NoNetworkView.a {
    final /* synthetic */ HotTopicActivity bpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HotTopicActivity hotTopicActivity) {
        this.bpp = hotTopicActivity;
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
            hVar = this.bpp.bpe;
            if (hVar != null) {
                hVar2 = this.bpp.bpe;
                if (hVar2.getHotTopicData() != null) {
                    hVar3 = this.bpp.bpe;
                    if (hVar3.getHotTopicData().Rm() != null) {
                        hVar4 = this.bpp.bpe;
                        if (hVar4.getHotTopicData().Rm().size() != 0) {
                            return;
                        }
                    }
                }
                HotTopicActivity hotTopicActivity = this.bpp;
                aVar = this.bpp.bpd;
                hotTopicActivity.hideNetRefreshView(aVar.Rs());
                aVar2 = this.bpp.bpd;
                aVar2.Rx();
            }
        }
    }
}
