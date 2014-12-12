package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bks;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bks = bVar;
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
                            list2 = this.bks.mList;
                            if (list2 != null) {
                                list3 = this.bks.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.rI().c(new h());
                            com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.rI().rZ();
                            com.baidu.tbadk.coreExtra.messageCenter.a.rI().rW();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.bks.mList;
                            if (list == null) {
                                return;
                            }
                            this.bks.bw(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bks.e(customResponsedMessage);
                    return;
                }
                this.bks.d(customResponsedMessage);
                return;
            }
            this.bks.c(customResponsedMessage);
        }
    }
}
