package com.baidu.tieba.im.mygroup;

import com.baidu.tieba.im.message.cy;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
/* loaded from: classes.dex */
final class d implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        switch (sVar.v()) {
            case -109:
            case 103101:
            case 103102:
            case 103104:
            case 103105:
            case 103112:
                if (sVar instanceof da) {
                    da daVar = (da) sVar;
                    if (daVar.l() && (!(sVar instanceof cy) || daVar.m() != 2230110)) {
                        return;
                    }
                }
                this.a.c = true;
                return;
            default:
                return;
        }
    }
}
