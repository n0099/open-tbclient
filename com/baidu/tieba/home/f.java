package com.baidu.tieba.home;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EnterForumActivity enterForumActivity) {
        this.f1450a = enterForumActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        switch (message.getCmd()) {
            case -109:
            case 103101:
            case 103102:
            case 103112:
                if (!(message instanceof ResponsedMessage) || !((ResponsedMessage) message).hasError()) {
                    oVar = this.f1450a.c;
                    if (oVar != null) {
                        oVar2 = this.f1450a.c;
                        if (oVar2.f1459a != null) {
                            if (this.f1450a.a()) {
                                oVar4 = this.f1450a.c;
                                oVar4.f1459a.f1477a.b();
                                return;
                            }
                            oVar3 = this.f1450a.c;
                            oVar3.f1459a.c = true;
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
