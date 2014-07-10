package com.baidu.tieba.im.c;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.MessageSyncMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<com.baidu.tieba.im.db.e> {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(com.baidu.tieba.im.db.e eVar) {
        int i;
        MessageSyncMessage m;
        long j;
        long j2;
        int i2;
        int i3;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (com.baidu.tieba.im.i.a() > 10) {
            handler3 = this.a.m;
            handler4 = this.a.m;
            handler3.sendMessageDelayed(handler4.obtainMessage(2), 2000L);
        } else if (com.baidu.tieba.im.b.e.d()) {
            this.a.e = false;
            MessageManager messageManager = MessageManager.getInstance();
            i = this.a.l;
            LinkedList<? extends Message> findMessage = messageManager.findMessage(202003, i);
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
                        i2 = this.a.g;
                        if (i2 < 20) {
                            b bVar = this.a;
                            i3 = bVar.g;
                            bVar.g = i3 + 1;
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
