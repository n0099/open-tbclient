package com.baidu.tbadk.n;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
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
            com.baidu.tbadk.util.j.OC();
            return socketResponsedMessage;
        }
        return socketResponsedMessage;
    }
}
