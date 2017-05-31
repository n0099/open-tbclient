package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a dfC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.dfC = aVar;
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
                            list2 = this.dfC.mList;
                            if (list2 != null) {
                                list3 = this.dfC.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.yn().c(new com.baidu.tbadk.coreExtra.c.e());
                            com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.yn().yF();
                            com.baidu.tbadk.coreExtra.messageCenter.a.yn().yB();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.dfC.mList;
                            if (list == null) {
                                return;
                            }
                            this.dfC.dU(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.dfC.f(customResponsedMessage);
                    return;
                }
                this.dfC.e(customResponsedMessage);
                return;
            }
            this.dfC.d(customResponsedMessage);
        }
    }
}
