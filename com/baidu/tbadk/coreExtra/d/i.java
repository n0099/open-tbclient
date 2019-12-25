package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class i extends j {
    public i() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getError() == 110004 && socketResponsedMessage.getCmd() != 1001) {
            com.baidu.tbadk.lcs.a.d(0, 0, 0, 1, 11);
            BdSocketLinkService.startService(true, "be server kicked off");
        }
        return socketResponsedMessage;
    }
}
