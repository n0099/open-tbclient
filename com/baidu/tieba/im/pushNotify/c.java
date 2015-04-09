package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bme;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bme = bVar;
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
                            list2 = this.bme.mList;
                            if (list2 != null) {
                                list3 = this.bme.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.uZ().c(new h());
                            com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vr();
                            com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vn();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.bme.mList;
                            if (list == null) {
                                return;
                            }
                            this.bme.bF(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bme.e(customResponsedMessage);
                    return;
                }
                this.bme.d(customResponsedMessage);
                return;
            }
            this.bme.c(customResponsedMessage);
        }
    }
}
