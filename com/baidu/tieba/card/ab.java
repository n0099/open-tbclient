package com.baidu.tieba.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements y.a {
    final /* synthetic */ x bml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.bml = xVar;
    }

    @Override // com.baidu.tieba.play.y.a
    public void JD() {
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
        pVar = this.bml.bmd;
        if (pVar != null) {
            pVar2 = this.bml.bmd;
            if (pVar2.aVi != null) {
                pVar3 = this.bml.bmd;
                if (pVar3.aVi.rN() != null) {
                    com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
                    pVar4 = this.bml.bmd;
                    bbVar.mLocate = pVar4.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
                    pVar5 = this.bml.bmd;
                    bbVar.bjS = pVar5.aVi.getTid();
                    pVar6 = this.bml.bmd;
                    bbVar.bjT = new StringBuilder(String.valueOf(pVar6.aVi.getFid())).toString();
                    bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    pVar7 = this.bml.bmd;
                    bbVar.mSource = pVar7.aVi.TW;
                    pVar8 = this.bml.bmd;
                    bbVar.eTy = pVar8.aVi.TY;
                    pVar9 = this.bml.bmd;
                    bbVar.eTz = pVar9.aVi.TX;
                    bbVar.eTA = "";
                    pVar10 = this.bml.bmd;
                    if (pVar10.aVi.sz() != null) {
                        pVar12 = this.bml.bmd;
                        if (pVar12.aVi.sz().channelId > 0) {
                            pVar13 = this.bml.bmd;
                            bbVar.Ql = new StringBuilder(String.valueOf(pVar13.aVi.sz().channelId)).toString();
                            pVar11 = this.bml.bmd;
                            com.baidu.tieba.play.ab.a(pVar11.aVi.rN().video_md5, "", "1", bbVar);
                        }
                    }
                    bbVar.Ql = "0";
                    pVar11 = this.bml.bmd;
                    com.baidu.tieba.play.ab.a(pVar11.aVi.rN().video_md5, "", "1", bbVar);
                }
            }
        }
    }
}
