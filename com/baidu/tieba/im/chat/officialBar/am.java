package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(OfficialBarInfoActivity officialBarInfoActivity) {
        super(MessageTypes.CMD_DEL_OFFICIAL_DB);
        this.a = officialBarInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003155) {
            this.a.showToast(com.baidu.tieba.u.cash_del_suc);
        }
    }
}
