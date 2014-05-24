package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.chat.bt {
    final /* synthetic */ CommonPersonalMsglistModel a;

    private i(CommonPersonalMsglistModel commonPersonalMsglistModel) {
        this.a = commonPersonalMsglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(CommonPersonalMsglistModel commonPersonalMsglistModel, i iVar) {
        this(commonPersonalMsglistModel);
    }

    @Override // com.baidu.tieba.im.chat.bt
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && responsedMessage.getCmd() == 205001 && (responsedMessage instanceof ResponseCommitPersonalMessage)) {
            ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) responsedMessage;
            if (responseCommitPersonalMessage.getError() == 2230303) {
                this.a.n();
            }
            this.a.a((ResponseCommitMessage) responseCommitPersonalMessage);
        }
    }
}
