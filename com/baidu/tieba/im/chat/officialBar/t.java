package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    final /* synthetic */ OfficialBarChatActivity aZk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aZk = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarMsglistView officialBarMsglistView;
        OfficialBarMsglistModel officialBarMsglistModel;
        OfficialBarMsglistModel officialBarMsglistModel2;
        OfficialBarMsglistView officialBarMsglistView2;
        OfficialBarMsglistModel officialBarMsglistModel3;
        OfficialBarMsglistModel officialBarMsglistModel4;
        OfficialBarMsglistModel officialBarMsglistModel5;
        OfficialBarMsglistView officialBarMsglistView3;
        if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
            this.aZk.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        com.baidu.tieba.im.data.e officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
        if (officialBarMenuDatas != null) {
            officialBarMsglistView2 = this.aZk.aZe;
            officialBarMsglistView2.cs(false);
            officialBarMsglistModel3 = this.aZk.aZf;
            officialBarMsglistModel3.setOfficialBarMenuDatas(officialBarMenuDatas);
            officialBarMsglistModel4 = this.aZk.aZf;
            officialBarMsglistModel5 = this.aZk.aZf;
            officialBarMsglistModel4.sendGetMenuNetMessage(officialBarMsglistModel5.getForumId(), officialBarMenuDatas.PR());
            officialBarMsglistView3 = this.aZk.aZe;
            officialBarMsglistView3.ay(officialBarMenuDatas.PS());
            return;
        }
        officialBarMsglistView = this.aZk.aZe;
        officialBarMsglistView.cs(true);
        officialBarMsglistModel = this.aZk.aZf;
        officialBarMsglistModel2 = this.aZk.aZf;
        officialBarMsglistModel.sendGetMenuNetMessage(officialBarMsglistModel2.getForumId(), 0L);
    }
}
