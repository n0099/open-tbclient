package com.baidu.tieba.card;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements w.a {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar) {
        this.bde = rVar;
    }

    @Override // com.baidu.tieba.play.w.a
    public void JW() {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        com.baidu.tieba.card.data.o oVar3;
        com.baidu.tieba.card.data.o oVar4;
        com.baidu.tieba.card.data.o oVar5;
        com.baidu.tieba.card.data.o oVar6;
        com.baidu.tieba.card.data.o oVar7;
        oVar = this.bde.bcW;
        if (oVar != null) {
            oVar2 = this.bde.bcW;
            if (oVar2.beS != null) {
                oVar3 = this.bde.bcW;
                if (oVar3.beS.sf() != null) {
                    oVar4 = this.bde.bcW;
                    String str = oVar4.beS.sf().video_md5;
                    oVar5 = this.bde.bcW;
                    String tid = oVar5.beS.getTid();
                    oVar6 = this.bde.bcW;
                    String sb = new StringBuilder(String.valueOf(oVar6.beS.getFid())).toString();
                    oVar7 = this.bde.bcW;
                    com.baidu.tieba.play.z.a(str, tid, sb, oVar7.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe", "", "", "1");
                }
            }
        }
    }
}
