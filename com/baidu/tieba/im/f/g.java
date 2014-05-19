package com.baidu.tieba.im.f;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        h hVar;
        h hVar2;
        h hVar3;
        double d;
        double d2;
        h hVar4;
        h hVar5;
        if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103010) {
            hVar = this.a.e;
            hVar.a();
        } else if (!(socketResponsedMessage instanceof ResponseRequestGroupLocMessage)) {
            hVar5 = this.a.e;
            hVar5.a();
        } else {
            ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage;
            if (responseRequestGroupLocMessage.getError() != 0) {
                hVar4 = this.a.e;
                hVar4.a();
                return;
            }
            Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
            ArrayList arrayList = new ArrayList();
            while (iteraotrOfBusinessAreaList.hasNext()) {
                arrayList.add(iteraotrOfBusinessAreaList.next());
            }
            String position = responseRequestGroupLocMessage.getPosition();
            if ((position == null || position.equals("")) && arrayList.size() < 1) {
                hVar2 = this.a.e;
                hVar2.a();
                return;
            }
            hVar3 = this.a.e;
            d = this.a.b;
            d2 = this.a.a;
            hVar3.a(position, arrayList, d, d2);
        }
    }
}
