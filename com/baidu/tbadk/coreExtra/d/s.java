package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.framework.a.m {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(q qVar, int i) {
        super(i);
        this.a = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.i
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponseOnlineMessage) {
            ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
            if (responseOnlineMessage.getError() == 0) {
                this.a.h();
                TiebaStatic.imLog((int) MessageTypes.CMD_UPDATE_CLIENT_INFO, 0, (String) null, "online succ", (String) null, responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
                BdLog.i("----online succ");
                return socketResponsedMessage;
            }
            this.a.a(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
            return null;
        }
        this.a.a(socketResponsedMessage.getCmd(), -1, (String) null);
        return null;
    }
}
