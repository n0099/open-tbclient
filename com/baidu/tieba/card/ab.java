package com.baidu.tieba.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements y.a {
    final /* synthetic */ x bvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.bvq = xVar;
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
        pVar = this.bvq.bvi;
        if (pVar != null) {
            pVar2 = this.bvq.bvi;
            if (pVar2.bck != null) {
                pVar3 = this.bvq.bvi;
                if (pVar3.bck.sF() != null) {
                    com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
                    pVar4 = this.bvq.bvi;
                    bbVar.mLocate = pVar4.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
                    pVar5 = this.bvq.bvi;
                    bbVar.bsL = pVar5.bck.getTid();
                    pVar6 = this.bvq.bvi;
                    bbVar.bsM = new StringBuilder(String.valueOf(pVar6.bck.getFid())).toString();
                    bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    pVar7 = this.bvq.bvi;
                    bbVar.mSource = pVar7.bck.Zy;
                    pVar8 = this.bvq.bvi;
                    bbVar.eXt = pVar8.bck.ZA;
                    pVar9 = this.bvq.bvi;
                    bbVar.eXu = pVar9.bck.Zz;
                    bbVar.eXv = "";
                    pVar10 = this.bvq.bvi;
                    if (pVar10.bck.ts() != null) {
                        pVar12 = this.bvq.bvi;
                        if (pVar12.bck.ts().channelId > 0) {
                            pVar13 = this.bvq.bvi;
                            bbVar.VR = new StringBuilder(String.valueOf(pVar13.bck.ts().channelId)).toString();
                            pVar11 = this.bvq.bvi;
                            com.baidu.tieba.play.ab.a(pVar11.bck.sF().video_md5, "", "1", bbVar);
                        }
                    }
                    bbVar.VR = "0";
                    pVar11 = this.bvq.bvi;
                    com.baidu.tieba.play.ab.a(pVar11.bck.sF().video_md5, "", "1", bbVar);
                }
            }
        }
    }
}
