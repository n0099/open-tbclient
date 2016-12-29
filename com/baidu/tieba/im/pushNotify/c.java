package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b cVM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.cVM = bVar;
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
                            list2 = this.cVM.mList;
                            if (list2 != null) {
                                list3 = this.cVM.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.yy().c(new com.baidu.tbadk.coreExtra.d.e());
                            com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.yy().yQ();
                            com.baidu.tbadk.coreExtra.messageCenter.a.yy().yM();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.cVM.mList;
                            if (list == null) {
                                return;
                            }
                            this.cVM.dj(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.cVM.g(customResponsedMessage);
                    return;
                }
                this.cVM.f(customResponsedMessage);
                return;
            }
            this.cVM.e(customResponsedMessage);
        }
    }
}
