package com.baidu.tieba.im.net.a;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestMarkReadedMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage b(Message message) {
        if (message != null && (message instanceof RequestMarkReadedMessage)) {
            com.baidu.tieba.im.db.a.a().b(((RequestMarkReadedMessage) message).getGroupId());
        }
        return null;
    }
}
