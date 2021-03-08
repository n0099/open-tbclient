package com.baidu.tbadk.q;

import com.baidu.adp.framework.b.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.util.o;
/* loaded from: classes.dex */
public class b extends j {
    public b() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.g
    /* renamed from: e */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null) {
            return null;
        }
        if (socketResponsedMessage.getError() == 2260104) {
            o.bFx();
            return socketResponsedMessage;
        }
        return socketResponsedMessage;
    }
}
