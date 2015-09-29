package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c bDo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.bDo = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean VO;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        VO = this.bDo.VO();
        if (VO && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.bCZ = this.bDo.VJ();
                bVar.bDa = this.bDo.VL();
                str = this.bDo.bDg;
                if (str == null) {
                    this.bDo.bDg = bVar.emitTime;
                }
                str2 = this.bDo.bDh;
                if (str2 == null) {
                    this.bDo.bDh = bVar.emitTime;
                }
                str3 = this.bDo.bDh;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bDo.bDh = bVar.emitTime;
                }
                str4 = this.bDo.bDg;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bDo.bDg = bVar.emitTime;
                }
                list = this.bDo.bDe;
                list.add(bVar);
            }
        }
    }
}
