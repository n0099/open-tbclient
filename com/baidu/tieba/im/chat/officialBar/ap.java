package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ OfficialBarTipActivity aSi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(OfficialBarTipActivity officialBarTipActivity, int i) {
        super(i);
        this.aSi = officialBarTipActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        au auVar;
        au auVar2;
        au auVar3;
        OfficialBarTipModel officialBarTipModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            officialBarTipModel = this.aSi.aSg;
                            aVar = this.aSi.aQP;
                            officialBarTipModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            auVar = this.aSi.aSh;
                            if (auVar != null) {
                                auVar2 = this.aSi.aSh;
                                if (auVar2.KC() != null) {
                                    auVar3 = this.aSi.aSh;
                                    auVar3.KC().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.aSi.e(customResponsedMessage);
                    return;
                }
                this.aSi.d(customResponsedMessage);
                return;
            }
            this.aSi.c(customResponsedMessage);
        }
    }
}
