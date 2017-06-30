package com.baidu.tieba.h;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class d extends j {
    public d() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getError() == 1990055 && !a.jW(socketResponsedMessage.getCmd())) {
            a.akj();
        }
        return socketResponsedMessage;
    }
}
