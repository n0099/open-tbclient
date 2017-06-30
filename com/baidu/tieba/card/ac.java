package com.baidu.tieba.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements y.a {
    final /* synthetic */ y bBU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.bBU = yVar;
    }

    @Override // com.baidu.tieba.play.y.a
    public void VF() {
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
        nVar = this.bBU.bBD;
        if (nVar != null) {
            nVar2 = this.bBU.bBD;
            if (nVar2.bai != null) {
                nVar3 = this.bBU.bBD;
                if (nVar3.bai.rI() != null) {
                    com.baidu.tieba.play.bc bcVar = new com.baidu.tieba.play.bc();
                    nVar4 = this.bBU.bBD;
                    bcVar.mLocate = nVar4.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
                    nVar5 = this.bBU.bBD;
                    bcVar.bxL = nVar5.bai.getTid();
                    nVar6 = this.bBU.bBD;
                    bcVar.bxM = new StringBuilder(String.valueOf(nVar6.bai.getFid())).toString();
                    bcVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    nVar7 = this.bBU.bBD;
                    bcVar.mSource = nVar7.bai.YN;
                    nVar8 = this.bBU.bBD;
                    bcVar.fmw = nVar8.bai.YP;
                    nVar9 = this.bBU.bBD;
                    bcVar.fmx = nVar9.bai.YO;
                    bcVar.fmy = "";
                    nVar10 = this.bBU.bBD;
                    if (nVar10.bai.sv() != null) {
                        nVar12 = this.bBU.bBD;
                        if (nVar12.bai.sv().channelId > 0) {
                            nVar13 = this.bBU.bBD;
                            bcVar.UW = new StringBuilder(String.valueOf(nVar13.bai.sv().channelId)).toString();
                            nVar11 = this.bBU.bBD;
                            com.baidu.tieba.play.ab.a(nVar11.bai.rI().video_md5, "", "1", bcVar);
                        }
                    }
                    bcVar.UW = "0";
                    nVar11 = this.bBU.bBD;
                    com.baidu.tieba.play.ab.a(nVar11.bai.rI().video_md5, "", "1", bcVar);
                }
            }
        }
    }
}
