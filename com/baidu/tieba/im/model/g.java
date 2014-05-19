package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ CommonPersonalMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(CommonPersonalMsglistModel commonPersonalMsglistModel, int i) {
        super(i);
        this.a = commonPersonalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null) {
            BdLog.e("msg == null");
        } else if (socketResponsedMessage.getCmd() != 205004) {
        } else {
            this.a.a(socketResponsedMessage);
        }
    }
}
