package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c bzF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.bzF = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean Vd;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        Vd = this.bzF.Vd();
        if (Vd && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.bzq = this.bzF.UY();
                bVar.bzr = this.bzF.Va();
                str = this.bzF.bzx;
                if (str == null) {
                    this.bzF.bzx = bVar.emitTime;
                }
                str2 = this.bzF.bzy;
                if (str2 == null) {
                    this.bzF.bzy = bVar.emitTime;
                }
                str3 = this.bzF.bzy;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bzF.bzy = bVar.emitTime;
                }
                str4 = this.bzF.bzx;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bzF.bzx = bVar.emitTime;
                }
                list = this.bzF.bzv;
                list.add(bVar);
            }
        }
    }
}
