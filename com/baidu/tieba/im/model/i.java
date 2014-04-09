package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements com.baidu.tieba.im.chat.bu {
    final /* synthetic */ CommonPersonalMsglistModel a;

    private i(CommonPersonalMsglistModel commonPersonalMsglistModel) {
        this.a = commonPersonalMsglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(CommonPersonalMsglistModel commonPersonalMsglistModel, byte b) {
        this(commonPersonalMsglistModel);
    }

    @Override // com.baidu.tieba.im.chat.bu
    public final void a(com.baidu.adp.framework.message.f<?> fVar) {
        if (fVar != null && fVar.g() == 205001 && (fVar instanceof ResponseCommitPersonalMessage)) {
            ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) fVar;
            if (responseCommitPersonalMessage.e() == 2230303) {
                this.a.k();
            }
            this.a.a(responseCommitPersonalMessage);
        }
    }
}
