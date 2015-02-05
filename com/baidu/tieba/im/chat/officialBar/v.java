package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class v extends CustomMessageListener {
    final /* synthetic */ OfficialBarChatActivity aUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aUo = officialBarChatActivity;
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
            this.aUo.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        com.baidu.tieba.im.data.e officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
        if (officialBarMenuDatas != null) {
            officialBarMsglistView2 = this.aUo.aUh;
            officialBarMsglistView2.cz(false);
            officialBarMsglistModel3 = this.aUo.aUi;
            officialBarMsglistModel3.setOfficialBarMenuDatas(officialBarMenuDatas);
            officialBarMsglistModel4 = this.aUo.aUi;
            officialBarMsglistModel5 = this.aUo.aUi;
            officialBarMsglistModel4.sendGetMenuNetMessage(officialBarMsglistModel5.getForumId(), officialBarMenuDatas.MF());
            officialBarMsglistView3 = this.aUo.aUh;
            officialBarMsglistView3.am(officialBarMenuDatas.MG());
            return;
        }
        officialBarMsglistView = this.aUo.aUh;
        officialBarMsglistView.cz(true);
        officialBarMsglistModel = this.aUo.aUi;
        officialBarMsglistModel2 = this.aUo.aUi;
        officialBarMsglistModel.sendGetMenuNetMessage(officialBarMsglistModel2.getForumId(), 0L);
    }
}
