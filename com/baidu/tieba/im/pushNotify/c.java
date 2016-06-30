package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b cVh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.cVh = bVar;
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
                            list2 = this.cVh.mList;
                            if (list2 != null) {
                                list3 = this.cVh.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.xn().c(new com.baidu.tbadk.coreExtra.d.e());
                            com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.xn().xF();
                            com.baidu.tbadk.coreExtra.messageCenter.a.xn().xB();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.cVh.mList;
                            if (list == null) {
                                return;
                            }
                            this.cVh.cV(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.cVh.g(customResponsedMessage);
                    return;
                }
                this.cVh.f(customResponsedMessage);
                return;
            }
            this.cVh.e(customResponsedMessage);
        }
    }
}
