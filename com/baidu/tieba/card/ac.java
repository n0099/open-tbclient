package com.baidu.tieba.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements y.a {
    final /* synthetic */ y bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.bBb = yVar;
    }

    @Override // com.baidu.tieba.play.y.a
    public void Uo() {
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
        nVar = this.bBb.bAK;
        if (nVar != null) {
            nVar2 = this.bBb.bAK;
            if (nVar2.aYA != null) {
                nVar3 = this.bBb.bAK;
                if (nVar3.aYA.rL() != null) {
                    com.baidu.tieba.play.bc bcVar = new com.baidu.tieba.play.bc();
                    nVar4 = this.bBb.bAK;
                    bcVar.mLocate = nVar4.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
                    nVar5 = this.bBb.bAK;
                    bcVar.buq = nVar5.aYA.getTid();
                    nVar6 = this.bBb.bAK;
                    bcVar.bur = new StringBuilder(String.valueOf(nVar6.aYA.getFid())).toString();
                    bcVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar7 = this.bBb.bAK;
                    bcVar.mSource = nVar7.aYA.YM;
                    nVar8 = this.bBb.bAK;
                    bcVar.fcg = nVar8.aYA.YO;
                    nVar9 = this.bBb.bAK;
                    bcVar.fch = nVar9.aYA.YN;
                    bcVar.fci = "";
                    nVar10 = this.bBb.bAK;
                    if (nVar10.aYA.sx() != null) {
                        nVar12 = this.bBb.bAK;
                        if (nVar12.aYA.sx().channelId > 0) {
                            nVar13 = this.bBb.bAK;
                            bcVar.UX = new StringBuilder(String.valueOf(nVar13.aYA.sx().channelId)).toString();
                            nVar11 = this.bBb.bAK;
                            com.baidu.tieba.play.ab.a(nVar11.aYA.rL().video_md5, "", "1", bcVar);
                        }
                    }
                    bcVar.UX = "0";
                    nVar11 = this.bBb.bAK;
                    com.baidu.tieba.play.ab.a(nVar11.aYA.rL().video_md5, "", "1", bcVar);
                }
            }
        }
    }
}
