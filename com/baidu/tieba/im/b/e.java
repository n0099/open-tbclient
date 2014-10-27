package com.baidu.tieba.im.b;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.this$0 = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean PB;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        PB = this.this$0.PB();
        if (PB && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.amX = this.this$0.Pw();
                bVar.bcA = this.this$0.Py();
                str = this.this$0.bcG;
                if (str == null) {
                    this.this$0.bcG = bVar.emitTime;
                }
                str2 = this.this$0.bcH;
                if (str2 == null) {
                    this.this$0.bcH = bVar.emitTime;
                }
                str3 = this.this$0.bcH;
                if (com.baidu.adp.lib.g.c.a(str3, 0L) < com.baidu.adp.lib.g.c.a(bVar.emitTime, 0L)) {
                    this.this$0.bcH = bVar.emitTime;
                }
                str4 = this.this$0.bcG;
                if (com.baidu.adp.lib.g.c.a(str4, 0L) > com.baidu.adp.lib.g.c.a(bVar.emitTime, 0L)) {
                    this.this$0.bcG = bVar.emitTime;
                }
                list = this.this$0.bcE;
                list.add(bVar);
            }
        }
    }
}
