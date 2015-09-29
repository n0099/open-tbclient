package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bGf = bVar;
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
                            list2 = this.bGf.mList;
                            if (list2 != null) {
                                list3 = this.bGf.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.wK().c(new com.baidu.tbadk.coreExtra.d.e());
                            com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.wK().xc();
                            com.baidu.tbadk.coreExtra.messageCenter.a.wK().wY();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.bGf.mList;
                            if (list == null) {
                                return;
                            }
                            this.bGf.bS(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bGf.g(customResponsedMessage);
                    return;
                }
                this.bGf.f(customResponsedMessage);
                return;
            }
            this.bGf.e(customResponsedMessage);
        }
    }
}
