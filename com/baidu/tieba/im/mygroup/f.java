package com.baidu.tieba.im.mygroup;

import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.o;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(o oVar) {
        switch (oVar.u()) {
            case -109:
            case 103101:
            case 103102:
            case 103104:
            case 103112:
                if (!(oVar instanceof cc) || !((cc) oVar).i()) {
                    this.a.b = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
