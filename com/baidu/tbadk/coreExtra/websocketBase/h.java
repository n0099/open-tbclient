package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class h extends j {
    public h() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getError() == 110004 && socketResponsedMessage.getCmd() != 1001) {
            BdSocketLinkService.startService(true, "be server kicked off");
        }
        return socketResponsedMessage;
    }
}
