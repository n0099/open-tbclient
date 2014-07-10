package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ OfficialBarChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.a = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarMsglistModel officialBarMsglistModel;
        OfficialBarMsglistModel officialBarMsglistModel2;
        OfficialBarMsglistModel officialBarMsglistModel3;
        OfficialBarMsglistModel officialBarMsglistModel4;
        OfficialBarMsglistModel officialBarMsglistModel5;
        OfficialBarMsglistView officialBarMsglistView;
        if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseOfficialBarMenuLocalMessage)) {
            this.a.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        com.baidu.tieba.im.data.m officialBarMenuDatas = ((ResponseOfficialBarMenuLocalMessage) customResponsedMessage).getOfficialBarMenuDatas();
        if (officialBarMenuDatas != null) {
            officialBarMsglistModel3 = this.a.n;
            officialBarMsglistModel3.a(officialBarMenuDatas);
            officialBarMsglistModel4 = this.a.n;
            officialBarMsglistModel5 = this.a.n;
            officialBarMsglistModel4.a(officialBarMsglistModel5.l(), officialBarMenuDatas.b());
            officialBarMsglistView = this.a.m;
            officialBarMsglistView.a(officialBarMenuDatas.c());
            return;
        }
        officialBarMsglistModel = this.a.n;
        officialBarMsglistModel2 = this.a.n;
        officialBarMsglistModel.a(officialBarMsglistModel2.l(), 0L);
    }
}
