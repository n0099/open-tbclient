package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aRf = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        OfficialBarMsglistView officialBarMsglistView;
        OfficialBarMsglistView officialBarMsglistView2;
        OfficialBarMsglistModel officialBarMsglistModel;
        OfficialBarMsglistView officialBarMsglistView3;
        OfficialBarMsglistModel officialBarMsglistModel2;
        OfficialBarMsglistView officialBarMsglistView4;
        officialBarMsglistView = this.aRf.aQY;
        officialBarMsglistView.cJ(false);
        if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
            this.aRf.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
        if (responseOfficialBarMenuMessage.hasError()) {
            if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                this.aRf.showToast(responseOfficialBarMenuMessage.getErrorString());
            } else {
                this.aRf.showToast(com.baidu.tieba.y.neterror);
            }
            officialBarMsglistModel2 = this.aRf.aQZ;
            com.baidu.tieba.im.data.g officialBarMenuDatas = officialBarMsglistModel2.getOfficialBarMenuDatas();
            if (officialBarMenuDatas == null || officialBarMenuDatas.Ms() == null || officialBarMenuDatas.Ms().size() == 0) {
                officialBarMsglistView4 = this.aRf.aQY;
                officialBarMsglistView4.cI(true);
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.g officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
        if (officialBarMenuDatas2 != null) {
            if (!officialBarMenuDatas2.Mq()) {
                officialBarMsglistView2 = this.aRf.aQY;
                officialBarMsglistView2.cI(true);
            } else if (officialBarMenuDatas2.Ms() != null && officialBarMenuDatas2.Ms().size() > 0) {
                officialBarMsglistModel = this.aRf.aQZ;
                officialBarMsglistModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                officialBarMsglistView3 = this.aRf.aQY;
                officialBarMsglistView3.P(officialBarMenuDatas2.Ms());
            }
        }
    }
}
