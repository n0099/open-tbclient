package com.baidu.tieba.i;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class c extends j {
    public c() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getError() == 1990055 && !a.nR(socketResponsedMessage.getCmd())) {
            a.aHP();
        }
        return socketResponsedMessage;
    }
}
