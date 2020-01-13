package com.baidu.tbadk.p;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.util.n;
/* loaded from: classes.dex */
public class b extends j {
    public b() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null) {
            return null;
        }
        if (socketResponsedMessage.getError() == 2260104) {
            n.aPI();
            return socketResponsedMessage;
        }
        return socketResponsedMessage;
    }
}
