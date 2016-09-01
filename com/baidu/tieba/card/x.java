package com.baidu.tieba.card;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements f.a {
    final /* synthetic */ t aZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.aZF = tVar;
    }

    @Override // com.baidu.tieba.play.f.a
    public void NB() {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        com.baidu.tieba.card.data.o oVar3;
        com.baidu.tieba.card.data.o oVar4;
        com.baidu.tieba.card.data.o oVar5;
        com.baidu.tieba.card.data.o oVar6;
        oVar = this.aZF.aZr;
        if (oVar != null) {
            oVar2 = this.aZF.aZr;
            if (oVar2.bbC != null) {
                oVar3 = this.aZF.aZr;
                if (oVar3.bbC.rR() != null) {
                    oVar4 = this.aZF.aZr;
                    String str = oVar4.bbC.rR().video_md5;
                    oVar5 = this.aZF.aZr;
                    String tid = oVar5.bbC.getTid();
                    oVar6 = this.aZF.aZr;
                    com.baidu.tieba.play.h.l(str, tid, new StringBuilder(String.valueOf(oVar6.bbC.getFid())).toString(), ImageViewerConfig.INDEX);
                }
            }
        }
    }
}
