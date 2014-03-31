package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.by;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements by {
    final /* synthetic */ CommonGroupMsglistModel a;

    private f(CommonGroupMsglistModel commonGroupMsglistModel) {
        this.a = commonGroupMsglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(CommonGroupMsglistModel commonGroupMsglistModel, byte b) {
        this(commonGroupMsglistModel);
    }

    @Override // com.baidu.tieba.im.chat.by
    public final void a(com.baidu.adp.framework.message.f<?> fVar) {
        if (fVar != null && fVar.g() == 202001 && (fVar instanceof ResponseCommitGroupMessage)) {
            ResponseCommitGroupMessage responseCommitGroupMessage = (ResponseCommitGroupMessage) fVar;
            if (CommonGroupMsglistModel.a(this.a, responseCommitGroupMessage)) {
                this.a.a((ResponseCommitMessage) responseCommitGroupMessage);
            }
        }
    }
}
