package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aRt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aRt = officialBarChatActivity;
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
        officialBarMsglistView = this.aRt.aRm;
        officialBarMsglistView.cJ(false);
        if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
            this.aRt.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
        if (responseOfficialBarMenuMessage.hasError()) {
            if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                this.aRt.showToast(responseOfficialBarMenuMessage.getErrorString());
            } else {
                this.aRt.showToast(com.baidu.tieba.y.neterror);
            }
            officialBarMsglistModel2 = this.aRt.aRn;
            com.baidu.tieba.im.data.g officialBarMenuDatas = officialBarMsglistModel2.getOfficialBarMenuDatas();
            if (officialBarMenuDatas == null || officialBarMenuDatas.Mw() == null || officialBarMenuDatas.Mw().size() == 0) {
                officialBarMsglistView4 = this.aRt.aRm;
                officialBarMsglistView4.cI(true);
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.g officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
        if (officialBarMenuDatas2 != null) {
            if (!officialBarMenuDatas2.Mu()) {
                officialBarMsglistView2 = this.aRt.aRm;
                officialBarMsglistView2.cI(true);
            } else if (officialBarMenuDatas2.Mw() != null && officialBarMenuDatas2.Mw().size() > 0) {
                officialBarMsglistModel = this.aRt.aRn;
                officialBarMsglistModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                officialBarMsglistView3 = this.aRt.aRm;
                officialBarMsglistView3.P(officialBarMenuDatas2.Mw());
            }
        }
    }
}
