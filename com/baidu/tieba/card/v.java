package com.baidu.tieba.card;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.play.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements h.a {
    final /* synthetic */ r aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar) {
        this.aZW = rVar;
    }

    @Override // com.baidu.tieba.play.h.a
    public void Ju() {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        com.baidu.tieba.card.data.o oVar3;
        com.baidu.tieba.card.data.o oVar4;
        com.baidu.tieba.card.data.o oVar5;
        com.baidu.tieba.card.data.o oVar6;
        oVar = this.aZW.aZM;
        if (oVar != null) {
            oVar2 = this.aZW.aZM;
            if (oVar2.bbU != null) {
                oVar3 = this.aZW.aZM;
                if (oVar3.bbU.sd() != null) {
                    oVar4 = this.aZW.aZM;
                    String str = oVar4.bbU.sd().video_md5;
                    oVar5 = this.aZW.aZM;
                    String tid = oVar5.bbU.getTid();
                    oVar6 = this.aZW.aZM;
                    com.baidu.tieba.play.j.a(str, tid, new StringBuilder(String.valueOf(oVar6.bbU.getFid())).toString(), ImageViewerConfig.INDEX, "", "", "1");
                }
            }
        }
    }
}
