package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.c.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b boI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.boI = bVar;
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
                            list2 = this.boI.mList;
                            if (list2 != null) {
                                list3 = this.boI.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.vJ().c(new h());
                            com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.vJ().wb();
                            com.baidu.tbadk.coreExtra.messageCenter.a.vJ().vX();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.boI.mList;
                            if (list == null) {
                                return;
                            }
                            this.boI.bO(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.boI.e(customResponsedMessage);
                    return;
                }
                this.boI.d(customResponsedMessage);
                return;
            }
            this.boI.c(customResponsedMessage);
        }
    }
}
