package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a dfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.dfq = aVar;
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
                            list2 = this.dfq.mList;
                            if (list2 != null) {
                                list3 = this.dfq.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.yK().c(new com.baidu.tbadk.coreExtra.c.e());
                            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.yK().zc();
                            com.baidu.tbadk.coreExtra.messageCenter.a.yK().yY();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.dfq.mList;
                            if (list == null) {
                                return;
                            }
                            this.dfq.dq(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.dfq.f(customResponsedMessage);
                    return;
                }
                this.dfq.e(customResponsedMessage);
                return;
            }
            this.dfq.d(customResponsedMessage);
        }
    }
}
