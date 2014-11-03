package com.baidu.tieba.game;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.online.GetOnLineInfoSocketResMessage;
/* loaded from: classes.dex */
class m extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof GetOnLineInfoSocketResMessage) {
            l.Hk().a(((GetOnLineInfoSocketResMessage) socketResponsedMessage).getGame());
        }
    }
}
