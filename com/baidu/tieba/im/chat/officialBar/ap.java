package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ OfficialBarTipActivity aRU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(OfficialBarTipActivity officialBarTipActivity, int i) {
        super(i);
        this.aRU = officialBarTipActivity;
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
                            officialBarTipModel = this.aRU.aRS;
                            aVar = this.aRU.aQB;
                            officialBarTipModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            auVar = this.aRU.aRT;
                            if (auVar != null) {
                                auVar2 = this.aRU.aRT;
                                if (auVar2.Ky() != null) {
                                    auVar3 = this.aRU.aRT;
                                    auVar3.Ky().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.aRU.e(customResponsedMessage);
                    return;
                }
                this.aRU.d(customResponsedMessage);
                return;
            }
            this.aRU.c(customResponsedMessage);
        }
    }
}
