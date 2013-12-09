package com.baidu.tieba.im.mygroup;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyGroupFragment f1839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyGroupFragment myGroupFragment) {
        this.f1839a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        switch (message.getCmd()) {
            case -109:
            case 103101:
            case 103102:
            case 103104:
            case 103112:
                if (!(message instanceof ResponsedMessage) || !((ResponsedMessage) message).hasError()) {
                    this.f1839a.b = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
