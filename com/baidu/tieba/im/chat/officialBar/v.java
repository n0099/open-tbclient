package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class v extends CustomMessageListener {
    final /* synthetic */ OfficialBarChatActivity aSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aSZ = officialBarChatActivity;
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
            this.aSZ.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        com.baidu.tieba.im.data.d officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
        if (officialBarMenuDatas != null) {
            officialBarMsglistModel3 = this.aSZ.aST;
            officialBarMsglistModel3.setOfficialBarMenuDatas(officialBarMenuDatas);
            officialBarMsglistModel4 = this.aSZ.aST;
            officialBarMsglistModel5 = this.aSZ.aST;
            officialBarMsglistModel4.sendGetMenuNetMessage(officialBarMsglistModel5.getForumId(), officialBarMenuDatas.Mo());
            officialBarMsglistView = this.aSZ.aSS;
            officialBarMsglistView.ak(officialBarMenuDatas.Mp());
            return;
        }
        officialBarMsglistModel = this.aSZ.aST;
        officialBarMsglistModel2 = this.aSZ.aST;
        officialBarMsglistModel.sendGetMenuNetMessage(officialBarMsglistModel2.getForumId(), 0L);
    }
}
