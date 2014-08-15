package com.baidu.tieba.im.b;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.MessageSyncMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.a<com.baidu.tieba.im.memorycache.a> {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(com.baidu.tieba.im.memorycache.a aVar) {
        BdUniqueId bdUniqueId;
        MessageSyncMessage m;
        long j;
        long j2;
        int i;
        int i2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (MessageManager.getInstance().getSocketClient().e() > 10) {
            handler3 = this.a.m;
            handler4 = this.a.m;
            handler3.sendMessageDelayed(handler4.obtainMessage(2), 2000L);
        } else if (com.baidu.tieba.im.memorycache.c.b().a()) {
            this.a.e = false;
            MessageManager messageManager = MessageManager.getInstance();
            bdUniqueId = this.a.l;
            LinkedList<? extends Message> findMessage = messageManager.findMessage(202003, bdUniqueId);
            if (findMessage != null && findMessage.size() > 0) {
                this.a.e = true;
                return;
            }
            if (TbadkApplication.m252getInst().isInBackground()) {
                long currentTimeMillis = System.currentTimeMillis();
                j = this.a.h;
                if (currentTimeMillis - j > TbConfig.USE_TIME_INTERVAL) {
                    j2 = this.a.f;
                    if (currentTimeMillis - j2 < 180000) {
                        i = this.a.g;
                        if (i < 20) {
                            b bVar = this.a;
                            i2 = bVar.g;
                            bVar.g = i2 + 1;
                            return;
                        }
                    }
                }
            }
            this.a.g = 0;
            m = this.a.m();
            MessageManager.getInstance().sendMessage(m);
        } else {
            handler = this.a.m;
            handler2 = this.a.m;
            handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
        }
    }
}
