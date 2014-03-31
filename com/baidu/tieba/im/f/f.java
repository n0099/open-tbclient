package com.baidu.tieba.im.f;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.framework.c.g {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(103010);
        this.a = dVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        g gVar;
        g gVar2;
        g gVar3;
        double d;
        double d2;
        g gVar4;
        g gVar5;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null || socketResponsedMessage2.g() != 103010) {
            gVar = this.a.e;
            gVar.a();
        } else if (!(socketResponsedMessage2 instanceof ResponseRequestGroupLocMessage)) {
            gVar5 = this.a.e;
            gVar5.a();
        } else {
            ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage2;
            if (responseRequestGroupLocMessage.e() != 0) {
                gVar4 = this.a.e;
                gVar4.a();
                return;
            }
            Iterator<String> i = responseRequestGroupLocMessage.i();
            ArrayList arrayList = new ArrayList();
            while (i.hasNext()) {
                arrayList.add(i.next());
            }
            String d3 = responseRequestGroupLocMessage.d();
            if ((d3 == null || d3.equals("")) && arrayList.size() <= 0) {
                gVar2 = this.a.e;
                gVar2.a();
                return;
            }
            gVar3 = this.a.e;
            d = this.a.b;
            d2 = this.a.a;
            gVar3.a(d3, arrayList, d, d2);
        }
    }
}
