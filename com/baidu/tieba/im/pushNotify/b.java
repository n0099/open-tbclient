package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a dcX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.dcX = aVar;
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
                            list2 = this.dcX.mList;
                            if (list2 != null) {
                                list3 = this.dcX.mList;
                                list3.clear();
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.a.yt().c(new com.baidu.tbadk.coreExtra.d.e());
                            com.baidu.tbadk.coreExtra.messageCenter.a.yt().setMsgChat(0);
                            com.baidu.tbadk.coreExtra.messageCenter.a.yt().yL();
                            com.baidu.tbadk.coreExtra.messageCenter.a.yt().yH();
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            list = this.dcX.mList;
                            if (list == null) {
                                return;
                            }
                            this.dcX.dq(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.dcX.g(customResponsedMessage);
                    return;
                }
                this.dcX.f(customResponsedMessage);
                return;
            }
            this.dcX.e(customResponsedMessage);
        }
    }
}
