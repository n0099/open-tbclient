package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ g aSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(g gVar, int i) {
        super(i);
        this.aSu = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterListAdapter imMessageCenterListAdapter2;
        ImMessageCenterListAdapter imMessageCenterListAdapter3;
        ImMessageCenterListAdapter imMessageCenterListAdapter4;
        ImMessageCenterModel imMessageCenterModel;
        a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            imMessageCenterModel = this.aSu.aSe;
                            aVar = this.aSu.aSt;
                            imMessageCenterModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            imMessageCenterListAdapter3 = this.aSu.aSi;
                            if (imMessageCenterListAdapter3 != null) {
                                imMessageCenterListAdapter4 = this.aSu.aSi;
                                imMessageCenterListAdapter4.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            imMessageCenterListAdapter = this.aSu.aSi;
                            if (imMessageCenterListAdapter != null) {
                                imMessageCenterListAdapter2 = this.aSu.aSi;
                                imMessageCenterListAdapter2.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.aSu.e(customResponsedMessage);
                    return;
                }
                this.aSu.d(customResponsedMessage);
                return;
            }
            this.aSu.c(customResponsedMessage);
        }
    }
}
