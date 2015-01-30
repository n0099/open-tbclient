package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class v extends CustomMessageListener {
    final /* synthetic */ OfficialBarChatActivity aUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aUp = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarMsglistModel officialBarMsglistModel;
        OfficialBarMsglistModel officialBarMsglistModel2;
        OfficialBarMsglistModel officialBarMsglistModel3;
        OfficialBarMsglistModel officialBarMsglistModel4;
        OfficialBarMsglistModel officialBarMsglistModel5;
        OfficialBarMsglistView officialBarMsglistView;
        if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
            this.aUp.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        com.baidu.tieba.im.data.e officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
        if (officialBarMenuDatas != null) {
            officialBarMsglistModel3 = this.aUp.aUj;
            officialBarMsglistModel3.setOfficialBarMenuDatas(officialBarMenuDatas);
            officialBarMsglistModel4 = this.aUp.aUj;
            officialBarMsglistModel5 = this.aUp.aUj;
            officialBarMsglistModel4.sendGetMenuNetMessage(officialBarMsglistModel5.getForumId(), officialBarMenuDatas.MK());
            officialBarMsglistView = this.aUp.aUi;
            officialBarMsglistView.am(officialBarMenuDatas.ML());
            return;
        }
        officialBarMsglistModel = this.aUp.aUj;
        officialBarMsglistModel2 = this.aUp.aUj;
        officialBarMsglistModel.sendGetMenuNetMessage(officialBarMsglistModel2.getForumId(), 0L);
    }
}
