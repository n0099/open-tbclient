package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ d bhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.bhm = dVar;
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
                            list2 = this.bhm.Wx;
                            if (list2 != null) {
                                list3 = this.bhm.Wx;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.oB().c(new com.baidu.tbadk.coreExtra.b.c());
                            com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.oB().oR();
                            com.baidu.tbadk.coreExtra.messageCenter.a.oB().oO();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.bhm.Wx;
                            if (list == null) {
                                return;
                            }
                            this.bhm.bE(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bhm.e(customResponsedMessage);
                    return;
                }
                this.bhm.d(customResponsedMessage);
                return;
            }
            this.bhm.c(customResponsedMessage);
        }
    }
}
