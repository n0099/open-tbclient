package com.baidu.tieba.im.b;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.performanceLog.x;
import com.baidu.tieba.im.message.MessageSyncMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.g<com.baidu.tieba.im.memorycache.a> {
    final /* synthetic */ b biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.biq = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: a */
    public void onReturnDataInUI(com.baidu.tieba.im.memorycache.a aVar) {
        BdUniqueId bdUniqueId;
        MessageSyncMessage Rc;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (MessageManager.getInstance().getSocketClient().aY() > 10) {
            x.a(false, true, false);
            handler3 = this.biq.mHandler;
            handler4 = this.biq.mHandler;
            handler3.sendMessageDelayed(handler4.obtainMessage(2), 2000L);
        } else if (com.baidu.tieba.im.memorycache.c.Qs().isInit()) {
            this.biq.bij = false;
            MessageManager messageManager = MessageManager.getInstance();
            bdUniqueId = this.biq.mTag;
            LinkedList<? extends Message> findMessage = messageManager.findMessage(202003, bdUniqueId);
            if (findMessage != null && findMessage.size() > 0) {
                x.a(false, false, true);
                this.biq.bij = true;
                return;
            }
            Rc = this.biq.Rc();
            MessageManager.getInstance().sendMessage(Rc);
            x.a(true, false, false);
        } else {
            handler = this.biq.mHandler;
            handler2 = this.biq.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
        }
    }
}
