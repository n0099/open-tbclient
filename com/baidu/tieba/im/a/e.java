package com.baidu.tieba.im.a;

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
        boolean Si;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        Si = this.this$0.Si();
        if (Si && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                b bVar = new b();
                bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                bVar.bja = this.this$0.Sd();
                bVar.bjb = this.this$0.Sf();
                str = this.this$0.bjh;
                if (str == null) {
                    this.this$0.bjh = bVar.emitTime;
                }
                str2 = this.this$0.bji;
                if (str2 == null) {
                    this.this$0.bji = bVar.emitTime;
                }
                str3 = this.this$0.bji;
                if (com.baidu.adp.lib.g.c.a(str3, 0L) < com.baidu.adp.lib.g.c.a(bVar.emitTime, 0L)) {
                    this.this$0.bji = bVar.emitTime;
                }
                str4 = this.this$0.bjh;
                if (com.baidu.adp.lib.g.c.a(str4, 0L) > com.baidu.adp.lib.g.c.a(bVar.emitTime, 0L)) {
                    this.this$0.bjh = bVar.emitTime;
                }
                list = this.this$0.bjf;
                list.add(bVar);
            }
        }
    }
}
