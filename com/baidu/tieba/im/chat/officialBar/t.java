package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aUo = officialBarChatActivity;
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
        officialBarMsglistView = this.aUo.aUh;
        officialBarMsglistView.cA(false);
        if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
            this.aUo.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
        if (responseOfficialBarMenuMessage.hasError()) {
            if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                this.aUo.showToast(responseOfficialBarMenuMessage.getErrorString());
            } else {
                this.aUo.showToast(com.baidu.tieba.z.neterror);
            }
            officialBarMsglistModel2 = this.aUo.aUi;
            com.baidu.tieba.im.data.e officialBarMenuDatas = officialBarMsglistModel2.getOfficialBarMenuDatas();
            if (officialBarMenuDatas == null || officialBarMenuDatas.MG() == null || officialBarMenuDatas.MG().size() == 0) {
                officialBarMsglistView5 = this.aUo.aUh;
                officialBarMsglistView5.cz(true);
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.e officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
        if (officialBarMenuDatas2 != null) {
            if (officialBarMenuDatas2.ME()) {
                officialBarMsglistView3 = this.aUo.aUh;
                officialBarMsglistView3.cz(false);
                if (officialBarMenuDatas2.MG() != null && officialBarMenuDatas2.MG().size() > 0) {
                    officialBarMsglistModel = this.aUo.aUi;
                    officialBarMsglistModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                    officialBarMsglistView4 = this.aUo.aUh;
                    officialBarMsglistView4.am(officialBarMenuDatas2.MG());
                    return;
                }
                return;
            }
            officialBarMsglistView2 = this.aUo.aUh;
            officialBarMsglistView2.cz(true);
        }
    }
}
