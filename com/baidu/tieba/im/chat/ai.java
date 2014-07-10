package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends CustomMessageListener {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(w wVar, int i) {
        super(i);
        this.a = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2001103) {
                if (customResponsedMessage instanceof LoadDraftResponsedMessage) {
                    this.a.a(customResponsedMessage);
                }
            } else if (customResponsedMessage.getCmd() == 2001105 && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
                this.a.a(customResponsedMessage);
            }
        }
    }
}
