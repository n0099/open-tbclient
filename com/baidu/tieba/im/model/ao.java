package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends CustomMessageListener {
    final /* synthetic */ OfficialBarMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(OfficialBarMsglistModel officialBarMsglistModel, int i) {
        super(i);
        this.a = officialBarMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2013003) {
                if (customResponsedMessage.getCmd() == 2001148) {
                    this.a.b(customResponsedMessage);
                    return;
                } else if (customResponsedMessage.getCmd() != 2001151) {
                    if (customResponsedMessage.getCmd() == 2001155) {
                        String str = (String) customResponsedMessage.getData();
                        if (this.a.a != null && this.a.a.getUserId().equals(str)) {
                            this.a.l();
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    this.a.c(customResponsedMessage);
                    return;
                }
            }
            this.a.d(customResponsedMessage);
        }
    }
}
