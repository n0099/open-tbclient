package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ad {
    final /* synthetic */ a aFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.aFe = aVar;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void au(boolean z) {
        com.baidu.tieba.enterForum.d.e eVar;
        com.baidu.tieba.enterForum.d.e eVar2;
        com.baidu.tieba.enterForum.d.e eVar3;
        if (!z) {
            eVar = this.aFe.aEM;
            eVar.Iy();
        } else if (this.aFe.isPrimary()) {
            eVar3 = this.aFe.aEM;
            eVar3.no();
        } else {
            eVar2 = this.aFe.aEM;
            eVar2.Iy();
        }
    }
}
