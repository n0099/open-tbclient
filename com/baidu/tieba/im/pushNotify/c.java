package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bDd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bDd = bVar;
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
                            list2 = this.bDd.mList;
                            if (list2 != null) {
                                list3 = this.bDd.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().c(new com.baidu.tbadk.coreExtra.c.f());
                            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xr();
                            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xn();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.bDd.mList;
                            if (list == null) {
                                return;
                            }
                            this.bDd.bV(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bDd.g(customResponsedMessage);
                    return;
                }
                this.bDd.f(customResponsedMessage);
                return;
            }
            this.bDd.e(customResponsedMessage);
        }
    }
}
