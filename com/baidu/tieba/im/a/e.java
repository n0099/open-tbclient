package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c dcP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.dcP = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean asU;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        asU = this.dcP.asU();
        if (asU && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.netType = this.dcP.asP();
                bVar.dcB = this.dcP.asR();
                str = this.dcP.dcH;
                if (str == null) {
                    this.dcP.dcH = bVar.emitTime;
                }
                str2 = this.dcP.dcI;
                if (str2 == null) {
                    this.dcP.dcI = bVar.emitTime;
                }
                str3 = this.dcP.dcI;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.dcP.dcI = bVar.emitTime;
                }
                str4 = this.dcP.dcH;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.dcP.dcH = bVar.emitTime;
                }
                list = this.dcP.dcF;
                list.add(bVar);
            }
        }
    }
}
