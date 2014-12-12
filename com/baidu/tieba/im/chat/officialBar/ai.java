package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ OfficialBarTipActivity aTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(OfficialBarTipActivity officialBarTipActivity, int i) {
        super(i);
        this.aTB = officialBarTipActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        OfficialBarTipModel officialBarTipModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            officialBarTipModel = this.aTB.aTz;
                            aVar = this.aTB.aSt;
                            officialBarTipModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            aoVar = this.aTB.aTA;
                            if (aoVar != null) {
                                aoVar2 = this.aTB.aTA;
                                if (aoVar2.KK() != null) {
                                    aoVar3 = this.aTB.aTA;
                                    aoVar3.KK().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.aTB.e(customResponsedMessage);
                    return;
                }
                this.aTB.d(customResponsedMessage);
                return;
            }
            this.aTB.c(customResponsedMessage);
        }
    }
}
