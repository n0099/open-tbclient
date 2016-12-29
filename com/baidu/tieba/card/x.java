package com.baidu.tieba.card;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements w.a {
    final /* synthetic */ t bcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bcw = tVar;
    }

    @Override // com.baidu.tieba.play.w.a
    public void Jp() {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        com.baidu.tieba.card.data.o oVar3;
        com.baidu.tieba.card.data.o oVar4;
        com.baidu.tieba.card.data.o oVar5;
        com.baidu.tieba.card.data.o oVar6;
        com.baidu.tieba.card.data.o oVar7;
        oVar = this.bcw.bco;
        if (oVar != null) {
            oVar2 = this.bcw.bco;
            if (oVar2.beB != null) {
                oVar3 = this.bcw.bco;
                if (oVar3.beB.rW() != null) {
                    oVar4 = this.bcw.bco;
                    String str = oVar4.beB.rW().video_md5;
                    oVar5 = this.bcw.bco;
                    String tid = oVar5.beB.getTid();
                    oVar6 = this.bcw.bco;
                    String sb = new StringBuilder(String.valueOf(oVar6.beB.getFid())).toString();
                    oVar7 = this.bcw.bco;
                    com.baidu.tieba.play.z.a(str, tid, sb, oVar7.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe", "", "", "1");
                }
            }
        }
    }
}
