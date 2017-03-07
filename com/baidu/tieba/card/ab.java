package com.baidu.tieba.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements y.a {
    final /* synthetic */ x btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.btf = xVar;
    }

    @Override // com.baidu.tieba.play.y.a
    public void Ki() {
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
        pVar = this.btf.bsX;
        if (pVar != null) {
            pVar2 = this.btf.bsX;
            if (pVar2.bbv != null) {
                pVar3 = this.btf.bsX;
                if (pVar3.bbv.sh() != null) {
                    com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
                    pVar4 = this.btf.bsX;
                    bbVar.mLocate = pVar4.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
                    pVar5 = this.btf.bsX;
                    bbVar.bqB = pVar5.bbv.getTid();
                    pVar6 = this.btf.bsX;
                    bbVar.bqC = new StringBuilder(String.valueOf(pVar6.bbv.getFid())).toString();
                    bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    pVar7 = this.btf.bsX;
                    bbVar.mSource = pVar7.bbv.Zh;
                    pVar8 = this.btf.bsX;
                    bbVar.eXe = pVar8.bbv.Zj;
                    pVar9 = this.btf.bsX;
                    bbVar.eXf = pVar9.bbv.Zi;
                    bbVar.eXg = "";
                    pVar10 = this.btf.bsX;
                    if (pVar10.bbv.sU() != null) {
                        pVar12 = this.btf.bsX;
                        if (pVar12.bbv.sU().channelId > 0) {
                            pVar13 = this.btf.bsX;
                            bbVar.Vy = new StringBuilder(String.valueOf(pVar13.bbv.sU().channelId)).toString();
                            pVar11 = this.btf.bsX;
                            com.baidu.tieba.play.ab.a(pVar11.bbv.sh().video_md5, "", "1", bbVar);
                        }
                    }
                    bbVar.Vy = "0";
                    pVar11 = this.btf.bsX;
                    com.baidu.tieba.play.ab.a(pVar11.bbv.sh().video_md5, "", "1", bbVar);
                }
            }
        }
    }
}
