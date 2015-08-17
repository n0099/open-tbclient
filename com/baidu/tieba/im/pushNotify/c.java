package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bCw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bCw = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List list2;
        List list3;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            list2 = this.bCw.mList;
                            if (list2 != null) {
                                list3 = this.bCw.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.wT().c(new com.baidu.tbadk.coreExtra.c.f());
                            com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.wT().xl();
                            com.baidu.tbadk.coreExtra.messageCenter.a.wT().xh();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.bCw.mList;
                            if (list == null) {
                                return;
                            }
                            this.bCw.bQ(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bCw.g(customResponsedMessage);
                    return;
                }
                this.bCw.f(customResponsedMessage);
                return;
            }
            this.bCw.e(customResponsedMessage);
        }
    }
}
