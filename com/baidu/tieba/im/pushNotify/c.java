package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b blO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.blO = bVar;
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
                            list2 = this.blO.mList;
                            if (list2 != null) {
                                list3 = this.blO.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.uT().c(new h());
                            com.baidu.tbadk.coreExtra.messageCenter.a.uT().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.uT().vl();
                            com.baidu.tbadk.coreExtra.messageCenter.a.uT().vh();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.blO.mList;
                            if (list == null) {
                                return;
                            }
                            this.blO.bF(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.blO.e(customResponsedMessage);
                    return;
                }
                this.blO.d(customResponsedMessage);
                return;
            }
            this.blO.c(customResponsedMessage);
        }
    }
}
