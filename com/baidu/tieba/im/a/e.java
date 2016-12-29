package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c cSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.cSz = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean arz;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        arz = this.cSz.arz();
        if (arz && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.cSk = this.cSz.aru();
                bVar.cSl = this.cSz.arw();
                str = this.cSz.cSr;
                if (str == null) {
                    this.cSz.cSr = bVar.emitTime;
                }
                str2 = this.cSz.cSs;
                if (str2 == null) {
                    this.cSz.cSs = bVar.emitTime;
                }
                str3 = this.cSz.cSs;
                if (com.baidu.adp.lib.h.b.c(str3, 0L) < com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.cSz.cSs = bVar.emitTime;
                }
                str4 = this.cSz.cSr;
                if (com.baidu.adp.lib.h.b.c(str4, 0L) > com.baidu.adp.lib.h.b.c(bVar.emitTime, 0L)) {
                    this.cSz.cSr = bVar.emitTime;
                }
                list = this.cSz.cSp;
                list.add(bVar);
            }
        }
    }
}
