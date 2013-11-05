package com.baidu.tieba.home;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EnterForumActivity enterForumActivity) {
        this.f1355a = enterForumActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        n nVar5;
        n nVar6;
        n nVar7;
        switch (message.getCmd()) {
            case -109:
                if (!(message instanceof ResponsedMessage) || !((ResponsedMessage) message).hasError()) {
                    nVar = this.f1355a.c;
                    if (nVar != null) {
                        nVar2 = this.f1355a.c;
                        if (nVar2.d != null) {
                            nVar3 = this.f1355a.c;
                            nVar3.d.c = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 103101:
            case 103102:
            case 103112:
                if (!(message instanceof ResponsedMessage) || !((ResponsedMessage) message).hasError()) {
                    nVar4 = this.f1355a.c;
                    if (nVar4 != null) {
                        nVar5 = this.f1355a.c;
                        if (nVar5.d != null) {
                            if (this.f1355a.b()) {
                                nVar7 = this.f1355a.c;
                                nVar7.d.f1381a.b();
                                return;
                            }
                            nVar6 = this.f1355a.c;
                            nVar6.d.c = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
