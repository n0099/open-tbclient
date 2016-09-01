package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.play.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements f.a {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bXm = aVar;
    }

    @Override // com.baidu.tieba.play.f.a
    public void NB() {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        bg bgVar6;
        bgVar = this.bXm.adL;
        if (bgVar != null) {
            bgVar2 = this.bXm.adL;
            if (bgVar2.rR() != null) {
                bgVar3 = this.bXm.adL;
                String str = bgVar3.su() ? "floor5" : "frs";
                bgVar4 = this.bXm.adL;
                String str2 = bgVar4.rR().video_md5;
                bgVar5 = this.bXm.adL;
                String tid = bgVar5.getTid();
                bgVar6 = this.bXm.adL;
                com.baidu.tieba.play.h.l(str2, tid, new StringBuilder(String.valueOf(bgVar6.getFid())).toString(), str);
            }
        }
    }
}
