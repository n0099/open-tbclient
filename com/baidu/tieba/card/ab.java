package com.baidu.tieba.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements y.a {
    final /* synthetic */ x bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.bsX = xVar;
    }

    @Override // com.baidu.tieba.play.y.a
    public void KI() {
        com.baidu.tieba.card.data.p pVar;
        com.baidu.tieba.card.data.p pVar2;
        com.baidu.tieba.card.data.p pVar3;
        com.baidu.tieba.card.data.p pVar4;
        com.baidu.tieba.card.data.p pVar5;
        com.baidu.tieba.card.data.p pVar6;
        com.baidu.tieba.card.data.p pVar7;
        com.baidu.tieba.card.data.p pVar8;
        com.baidu.tieba.card.data.p pVar9;
        com.baidu.tieba.card.data.p pVar10;
        com.baidu.tieba.card.data.p pVar11;
        com.baidu.tieba.card.data.p pVar12;
        com.baidu.tieba.card.data.p pVar13;
        pVar = this.bsX.bsP;
        if (pVar != null) {
            pVar2 = this.bsX.bsP;
            if (pVar2.bbo != null) {
                pVar3 = this.bsX.bsP;
                if (pVar3.bbo.sF() != null) {
                    com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
                    pVar4 = this.bsX.bsP;
                    bbVar.mLocate = pVar4.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
                    pVar5 = this.bsX.bsP;
                    bbVar.bqu = pVar5.bbo.getTid();
                    pVar6 = this.bsX.bsP;
                    bbVar.bqv = new StringBuilder(String.valueOf(pVar6.bbo.getFid())).toString();
                    bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    pVar7 = this.bsX.bsP;
                    bbVar.mSource = pVar7.bbo.Zx;
                    pVar8 = this.bsX.bsP;
                    bbVar.eVd = pVar8.bbo.Zz;
                    pVar9 = this.bsX.bsP;
                    bbVar.eVe = pVar9.bbo.Zy;
                    bbVar.eVf = "";
                    pVar10 = this.bsX.bsP;
                    if (pVar10.bbo.ts() != null) {
                        pVar12 = this.bsX.bsP;
                        if (pVar12.bbo.ts().channelId > 0) {
                            pVar13 = this.bsX.bsP;
                            bbVar.VP = new StringBuilder(String.valueOf(pVar13.bbo.ts().channelId)).toString();
                            pVar11 = this.bsX.bsP;
                            com.baidu.tieba.play.ab.a(pVar11.bbo.sF().video_md5, "", "1", bbVar);
                        }
                    }
                    bbVar.VP = "0";
                    pVar11 = this.bsX.bsP;
                    com.baidu.tieba.play.ab.a(pVar11.bbo.sF().video_md5, "", "1", bbVar);
                }
            }
        }
    }
}
