package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a dnx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.dnx = aVar;
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
                            list2 = this.dnx.mList;
                            if (list2 != null) {
                                list3 = this.dnx.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.yG().c(new com.baidu.tbadk.coreExtra.c.e());
                            com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.yG().yY();
                            com.baidu.tbadk.coreExtra.messageCenter.a.yG().yU();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.dnx.mList;
                            if (list == null) {
                                return;
                            }
                            this.dnx.el(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.dnx.f(customResponsedMessage);
                    return;
                }
                this.dnx.e(customResponsedMessage);
                return;
            }
            this.dnx.d(customResponsedMessage);
        }
    }
}
