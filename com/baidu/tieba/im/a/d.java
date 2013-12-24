package com.baidu.tieba.im.a;

import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.n;
import com.baidu.tieba.im.messageCenter.g;
/* loaded from: classes.dex */
class d implements g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(n nVar) {
        switch (nVar.t()) {
            case 103101:
            case 103102:
            case 103104:
            case 103112:
                if (!(nVar instanceof bz) || !((bz) nVar).i()) {
                    a.a = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
