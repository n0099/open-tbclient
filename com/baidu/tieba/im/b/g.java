package com.baidu.tieba.im.b;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ b biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b bVar, int i) {
        super(i);
        this.biq = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 1003) {
                if (!(socketResponsedMessage instanceof ResponsedMessage) || socketResponsedMessage.getError() != 0) {
                    return;
                }
                this.biq.Rb();
            } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                TiebaStatic.imNet(responseOnlineMessage);
                if (responseOnlineMessage.getError() == 0) {
                    this.biq.bik = responseOnlineMessage.getGroupInfos();
                    if (com.baidu.tieba.im.memorycache.c.Qs().isInit()) {
                        this.biq.QU();
                    }
                }
            }
        }
    }
}
