package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.messageCenter.g;
/* loaded from: classes.dex */
class d implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f1530a = aVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        switch (message.getCmd()) {
            case 103101:
            case 103102:
            case 103104:
            case 103112:
                if (!(message instanceof ResponsedMessage) || !((ResponsedMessage) message).hasError()) {
                    a.f1527a = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
