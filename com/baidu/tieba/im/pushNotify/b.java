package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a ddM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.ddM = aVar;
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
                            list2 = this.ddM.mList;
                            if (list2 != null) {
                                list3 = this.ddM.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.zj().c(new com.baidu.tbadk.coreExtra.c.e());
                            com.baidu.tbadk.coreExtra.messageCenter.a.zj().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.zj().zB();
                            com.baidu.tbadk.coreExtra.messageCenter.a.zj().zx();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.ddM.mList;
                            if (list == null) {
                                return;
                            }
                            this.ddM.ds(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.ddM.f(customResponsedMessage);
                    return;
                }
                this.ddM.e(customResponsedMessage);
                return;
            }
            this.ddM.d(customResponsedMessage);
        }
    }
}
