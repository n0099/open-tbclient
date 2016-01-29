package com.baidu.tieba.enterForum.square;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements r.a {
    final /* synthetic */ b aXD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aXD = bVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        boolean z2;
        e eVar;
        a aVar;
        if (!i.iZ()) {
            aVar = this.aXD.aXz;
            aVar.MB();
            this.aXD.fV(t.j.neterror);
            return;
        }
        z2 = this.aXD.aXB;
        if (!z2) {
            eVar = this.aXD.aXy;
            eVar.sendMessage();
            this.aXD.aXB = true;
        }
    }
}
