package com.baidu.tieba.enterForum.square;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements s.a {
    final /* synthetic */ b bcm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bcm = bVar;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        boolean z2;
        e eVar;
        a aVar;
        if (!i.jf()) {
            aVar = this.bcm.bci;
            aVar.Op();
            this.bcm.gl(t.j.neterror);
            return;
        }
        z2 = this.bcm.bck;
        if (!z2) {
            eVar = this.bcm.bch;
            eVar.sendMessage();
            this.bcm.bck = true;
        }
    }
}
