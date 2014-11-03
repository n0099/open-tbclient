package com.baidu.tieba.im.c;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.performanceLog.q;
import com.baidu.tieba.im.message.MessageSyncMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.a<com.baidu.tieba.im.memorycache.a> {
    final /* synthetic */ b beX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.beX = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: a */
    public void onReturnDataInUI(com.baidu.tieba.im.memorycache.a aVar) {
        BdUniqueId bdUniqueId;
        MessageSyncMessage QD;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (MessageManager.getInstance().getSocketClient().ay() > 10) {
            q.a(false, true, false);
            handler3 = this.beX.mHandler;
            handler4 = this.beX.mHandler;
            handler3.sendMessageDelayed(handler4.obtainMessage(2), 2000L);
        } else if (com.baidu.tieba.im.memorycache.c.PN().PM()) {
            this.beX.beQ = false;
            MessageManager messageManager = MessageManager.getInstance();
            bdUniqueId = this.beX.mTag;
            LinkedList<? extends Message> findMessage = messageManager.findMessage(202003, bdUniqueId);
            if (findMessage != null && findMessage.size() > 0) {
                q.a(false, false, true);
                this.beX.beQ = true;
                return;
            }
            QD = this.beX.QD();
            MessageManager.getInstance().sendMessage(QD);
            q.a(true, false, false);
        } else {
            handler = this.beX.mHandler;
            handler2 = this.beX.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
        }
    }
}
