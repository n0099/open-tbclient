package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aUp = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        OfficialBarMsglistView officialBarMsglistView;
        OfficialBarMsglistView officialBarMsglistView2;
        OfficialBarMsglistView officialBarMsglistView3;
        OfficialBarMsglistModel officialBarMsglistModel;
        OfficialBarMsglistView officialBarMsglistView4;
        OfficialBarMsglistModel officialBarMsglistModel2;
        OfficialBarMsglistView officialBarMsglistView5;
        officialBarMsglistView = this.aUp.aUi;
        officialBarMsglistView.cA(false);
        if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
            this.aUp.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
        if (responseOfficialBarMenuMessage.hasError()) {
            if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                this.aUp.showToast(responseOfficialBarMenuMessage.getErrorString());
            } else {
                this.aUp.showToast(com.baidu.tieba.z.neterror);
            }
            officialBarMsglistModel2 = this.aUp.aUj;
            com.baidu.tieba.im.data.e officialBarMenuDatas = officialBarMsglistModel2.getOfficialBarMenuDatas();
            if (officialBarMenuDatas == null || officialBarMenuDatas.ML() == null || officialBarMenuDatas.ML().size() == 0) {
                officialBarMsglistView5 = this.aUp.aUi;
                officialBarMsglistView5.cz(true);
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.e officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
        if (officialBarMenuDatas2 != null) {
            if (officialBarMenuDatas2.MJ()) {
                officialBarMsglistView3 = this.aUp.aUi;
                officialBarMsglistView3.cz(false);
                if (officialBarMenuDatas2.ML() != null && officialBarMenuDatas2.ML().size() > 0) {
                    officialBarMsglistModel = this.aUp.aUj;
                    officialBarMsglistModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                    officialBarMsglistView4 = this.aUp.aUi;
                    officialBarMsglistView4.am(officialBarMenuDatas2.ML());
                    return;
                }
                return;
            }
            officialBarMsglistView2 = this.aUp.aUi;
            officialBarMsglistView2.cz(true);
        }
    }
}
