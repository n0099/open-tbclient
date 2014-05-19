package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends CustomMessageListener {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(x xVar, int i) {
        super(i);
        this.a = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null) {
            BdLog.e("msg == null");
        } else if (customResponsedMessage.getCmd() == 2003103) {
            if (customResponsedMessage instanceof LoadDraftResponsedMessage) {
                this.a.a(customResponsedMessage);
            }
        } else if (customResponsedMessage.getCmd() == 2003105) {
            if (customResponsedMessage instanceof LoadHistoryResponsedMessage) {
                this.a.a(customResponsedMessage);
            }
        } else {
            BdLog.e("convert error need GroupMsgData");
        }
    }
}
