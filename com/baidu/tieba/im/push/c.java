package com.baidu.tieba.im.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Vector;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ a coI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, Looper looper) {
        super(looper);
        this.coI = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Vector vector;
        CustomMessageListener customMessageListener;
        switch (message.what) {
            case 10001:
                MessageUtils.updateGroupNotExist(message.getData());
                return;
            case 10002:
                MessageManager messageManager = MessageManager.getInstance();
                customMessageListener = this.coI.cnP;
                messageManager.registerListener(customMessageListener);
                return;
            case 10003:
                if (message.getData() != null && message.getData().containsKey("groupId")) {
                    vector = this.coI.coH;
                    vector.remove(Long.valueOf(message.getData().getLong("groupId")));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
