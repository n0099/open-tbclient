package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b blP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.blP = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List list2;
        List list3;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            list2 = this.blP.mList;
                            if (list2 != null) {
                                list3 = this.blP.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.rY().c(new h());
                            com.baidu.tbadk.coreExtra.messageCenter.a.rY().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.rY().sp();
                            com.baidu.tbadk.coreExtra.messageCenter.a.rY().sm();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.blP.mList;
                            if (list == null) {
                                return;
                            }
                            this.blP.bz(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.blP.e(customResponsedMessage);
                    return;
                }
                this.blP.d(customResponsedMessage);
                return;
            }
            this.blP.c(customResponsedMessage);
        }
    }
}
