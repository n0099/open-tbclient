package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bGL = bVar;
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
                            list2 = this.bGL.mList;
                            if (list2 != null) {
                                list3 = this.bGL.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.wM().c(new com.baidu.tbadk.coreExtra.d.e());
                            com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.wM().xe();
                            com.baidu.tbadk.coreExtra.messageCenter.a.wM().xa();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.bGL.mList;
                            if (list == null) {
                                return;
                            }
                            this.bGL.bU(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bGL.g(customResponsedMessage);
                    return;
                }
                this.bGL.f(customResponsedMessage);
                return;
            }
            this.bGL.e(customResponsedMessage);
        }
    }
}
