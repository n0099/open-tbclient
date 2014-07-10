package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.chat.bt {
    final /* synthetic */ CommonPersonalMsglistModel a;

    private g(CommonPersonalMsglistModel commonPersonalMsglistModel) {
        this.a = commonPersonalMsglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(CommonPersonalMsglistModel commonPersonalMsglistModel, g gVar) {
        this(commonPersonalMsglistModel);
    }

    @Override // com.baidu.tieba.im.chat.bt
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && responsedMessage.getCmd() == 205001 && (responsedMessage instanceof ResponseCommitPersonalMessage)) {
            this.a.a((ResponseCommitPersonalMessage) responsedMessage);
        }
    }
}
