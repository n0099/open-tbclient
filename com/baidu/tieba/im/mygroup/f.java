package com.baidu.tieba.im.mygroup;

import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.n;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(n nVar) {
        switch (nVar.t()) {
            case -109:
            case 103101:
            case 103102:
            case 103104:
            case 103112:
                if (!(nVar instanceof bz) || !((bz) nVar).i()) {
                    this.a.b = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
