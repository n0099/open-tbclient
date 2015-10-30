package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c bDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.bDz = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean VK;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        VK = this.bDz.VK();
        if (VK && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.bDk = this.bDz.VF();
                bVar.bDl = this.bDz.VH();
                str = this.bDz.bDr;
                if (str == null) {
                    this.bDz.bDr = bVar.emitTime;
                }
                str2 = this.bDz.bDs;
                if (str2 == null) {
                    this.bDz.bDs = bVar.emitTime;
                }
                str3 = this.bDz.bDs;
                if (com.baidu.adp.lib.g.b.c(str3, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bDz.bDs = bVar.emitTime;
                }
                str4 = this.bDz.bDr;
                if (com.baidu.adp.lib.g.b.c(str4, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                    this.bDz.bDr = bVar.emitTime;
                }
                list = this.bDz.bDp;
                list.add(bVar);
            }
        }
    }
}
