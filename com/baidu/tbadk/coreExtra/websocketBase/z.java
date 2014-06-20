package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.framework.a.j {
    public z() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getError() == 110004) {
            BdSocketLinkService.startService(true, "be server kicked off");
        }
        return socketResponsedMessage;
    }
}
