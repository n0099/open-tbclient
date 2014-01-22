package com.baidu.tieba.im.mygroup;

import com.baidu.tieba.im.message.cp;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.message.q;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        switch (qVar.w()) {
            case -109:
            case 103101:
            case 103102:
            case 103104:
            case 103105:
            case 103112:
                if (qVar instanceof cr) {
                    cr crVar = (cr) qVar;
                    if (crVar.k() && (!(qVar instanceof cp) || crVar.l() != 2230110)) {
                        return;
                    }
                }
                this.a.b = true;
                return;
            default:
                return;
        }
    }
}
