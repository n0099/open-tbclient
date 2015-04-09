package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements y {
    final /* synthetic */ a aDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.aDb = aVar;
    }

    @Override // com.baidu.tbadk.core.view.y
    public void an(boolean z) {
        com.baidu.tieba.enterForum.d.e eVar;
        com.baidu.tieba.enterForum.d.e eVar2;
        com.baidu.tieba.enterForum.d.e eVar3;
        if (!z) {
            eVar = this.aDb.aCJ;
            eVar.Hx();
        } else if (this.aDb.isPrimary()) {
            eVar3 = this.aDb.aCJ;
            eVar3.mX();
        } else {
            eVar2 = this.aDb.aCJ;
            eVar2.Hx();
        }
    }
}
