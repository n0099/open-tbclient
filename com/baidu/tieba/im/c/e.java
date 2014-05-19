package com.baidu.tieba.im.c;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
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
        MessageSyncMessage l;
        long j;
        long j2;
        int i2;
        int i3;
        int i4;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (com.baidu.tieba.im.i.a() > 10) {
            BdLog.i("----pull message, but TiebaIMSingleExecutor.QueueSize too big");
            handler3 = this.a.l;
            handler4 = this.a.l;
            handler3.sendMessageDelayed(handler4.obtainMessage(2), 2000L);
        } else if (com.baidu.tieba.im.b.e.d()) {
            this.a.e = false;
            MessageManager messageManager = MessageManager.getInstance();
            i = this.a.k;
            LinkedList<? extends Message> findMessage = messageManager.findMessage(MessageTypes.CMD_MESSAGE_SYNC, i);
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
                            StringBuilder sb = new StringBuilder("----background pull skip. no pull count ");
                            i4 = this.a.g;
                            BdLog.i(sb.append(i4).toString());
                            return;
                        }
                    }
                }
            }
            BdLog.i("----real pull msg.");
            this.a.g = 0;
            l = this.a.l();
            MessageManager.getInstance().sendMessage(l);
        } else {
            BdLog.i("----pull message, but cache is initing... ");
            handler = this.a.l;
            handler2 = this.a.l;
            handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
        }
    }
}
