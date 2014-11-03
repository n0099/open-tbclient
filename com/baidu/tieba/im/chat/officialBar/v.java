package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class v extends CustomMessageListener {
    final /* synthetic */ OfficialBarChatActivity aRt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aRt = officialBarChatActivity;
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
            this.aRt.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        com.baidu.tieba.im.data.g officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
        if (officialBarMenuDatas != null) {
            officialBarMsglistModel3 = this.aRt.aRn;
            officialBarMsglistModel3.setOfficialBarMenuDatas(officialBarMenuDatas);
            officialBarMsglistModel4 = this.aRt.aRn;
            officialBarMsglistModel5 = this.aRt.aRn;
            officialBarMsglistModel4.sendGetMenuNetMessage(officialBarMsglistModel5.getForumId(), officialBarMenuDatas.Mv());
            officialBarMsglistView = this.aRt.aRm;
            officialBarMsglistView.P(officialBarMenuDatas.Mw());
            return;
        }
        officialBarMsglistModel = this.aRt.aRn;
        officialBarMsglistModel2 = this.aRt.aRn;
        officialBarMsglistModel.sendGetMenuNetMessage(officialBarMsglistModel2.getForumId(), 0L);
    }
}
