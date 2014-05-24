package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.chat.bt {
    final /* synthetic */ CommonGroupMsglistModel a;

    private f(CommonGroupMsglistModel commonGroupMsglistModel) {
        this.a = commonGroupMsglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(CommonGroupMsglistModel commonGroupMsglistModel, f fVar) {
        this(commonGroupMsglistModel);
    }

    @Override // com.baidu.tieba.im.chat.bt
    public void a(ResponsedMessage<?> responsedMessage) {
        boolean a;
        if (responsedMessage != null && responsedMessage.getCmd() == 202001 && (responsedMessage instanceof ResponseCommitGroupMessage)) {
            ResponseCommitGroupMessage responseCommitGroupMessage = (ResponseCommitGroupMessage) responsedMessage;
            a = this.a.a(responseCommitGroupMessage);
            if (a) {
                this.a.a((ResponseCommitMessage) responseCommitGroupMessage);
            }
        }
    }
}
