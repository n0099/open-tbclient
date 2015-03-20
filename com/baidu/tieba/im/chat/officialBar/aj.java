package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    final /* synthetic */ OfficialBarTipActivity aZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(OfficialBarTipActivity officialBarTipActivity, int i) {
        super(i);
        this.aZE = officialBarTipActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ap apVar;
        ap apVar2;
        ap apVar3;
        OfficialBarTipModel officialBarTipModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            officialBarTipModel = this.aZE.aZA;
                            aVar = this.aZE.aZD;
                            officialBarTipModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            apVar = this.aZE.aZB;
                            if (apVar != null) {
                                apVar2 = this.aZE.aZB;
                                if (apVar2.Of() != null) {
                                    apVar3 = this.aZE.aZB;
                                    apVar3.Of().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.aZE.e(customResponsedMessage);
                    return;
                }
                this.aZE.d(customResponsedMessage);
                return;
            }
            this.aZE.c(customResponsedMessage);
        }
    }
}
