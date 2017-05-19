package com.baidu.tieba.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements y.a {
    final /* synthetic */ u bvn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.bvn = uVar;
    }

    @Override // com.baidu.tieba.play.y.a
    public void JW() {
        com.baidu.tieba.card.data.n nVar;
        com.baidu.tieba.card.data.n nVar2;
        com.baidu.tieba.card.data.n nVar3;
        com.baidu.tieba.card.data.n nVar4;
        com.baidu.tieba.card.data.n nVar5;
        com.baidu.tieba.card.data.n nVar6;
        com.baidu.tieba.card.data.n nVar7;
        com.baidu.tieba.card.data.n nVar8;
        com.baidu.tieba.card.data.n nVar9;
        com.baidu.tieba.card.data.n nVar10;
        com.baidu.tieba.card.data.n nVar11;
        com.baidu.tieba.card.data.n nVar12;
        com.baidu.tieba.card.data.n nVar13;
        nVar = this.bvn.bvd;
        if (nVar != null) {
            nVar2 = this.bvn.bvd;
            if (nVar2.bcB != null) {
                nVar3 = this.bvn.bvd;
                if (nVar3.bcB.rP() != null) {
                    com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
                    nVar4 = this.bvn.bvd;
                    bbVar.mLocate = nVar4.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
                    nVar5 = this.bvn.bvd;
                    bbVar.bti = nVar5.bcB.getTid();
                    nVar6 = this.bvn.bvd;
                    bbVar.btj = new StringBuilder(String.valueOf(nVar6.bcB.getFid())).toString();
                    bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar7 = this.bvn.bvd;
                    bbVar.mSource = nVar7.bcB.YQ;
                    nVar8 = this.bvn.bvd;
                    bbVar.eTt = nVar8.bcB.YS;
                    nVar9 = this.bvn.bvd;
                    bbVar.eTu = nVar9.bcB.YR;
                    bbVar.eTv = "";
                    nVar10 = this.bvn.bvd;
                    if (nVar10.bcB.sC() != null) {
                        nVar12 = this.bvn.bvd;
                        if (nVar12.bcB.sC().channelId > 0) {
                            nVar13 = this.bvn.bvd;
                            bbVar.Vk = new StringBuilder(String.valueOf(nVar13.bcB.sC().channelId)).toString();
                            nVar11 = this.bvn.bvd;
                            com.baidu.tieba.play.ab.a(nVar11.bcB.rP().video_md5, "", "1", bbVar);
                        }
                    }
                    bbVar.Vk = "0";
                    nVar11 = this.bvn.bvd;
                    com.baidu.tieba.play.ab.a(nVar11.bcB.rP().video_md5, "", "1", bbVar);
                }
            }
        }
    }
}
