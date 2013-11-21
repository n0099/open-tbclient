package com.baidu.tieba.home;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1441a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EnterForumActivity enterForumActivity) {
        this.f1441a = enterForumActivity;
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
                    oVar = this.f1441a.c;
                    if (oVar != null) {
                        oVar2 = this.f1441a.c;
                        if (oVar2.f1450a != null) {
                            if (this.f1441a.a()) {
                                oVar4 = this.f1441a.c;
                                oVar4.f1450a.f1468a.b();
                                return;
                            }
                            oVar3 = this.f1441a.c;
                            oVar3.f1450a.c = true;
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
